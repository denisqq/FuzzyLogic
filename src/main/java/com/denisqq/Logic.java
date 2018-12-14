package com.denisqq;

import com.denisqq.rule.Conclusion;
import com.denisqq.rule.Condition;
import com.denisqq.rule.Rule;
import com.denisqq.set.ActivatedFuzzySet;
import com.denisqq.set.FuzzySet;
import com.denisqq.set.UnionOfFuzzySets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.IntStream;

public class Logic {

    private List<Rule> rules;

    public Map<Integer, List<Double>> fuzzification(final List<Double> values){
        Map<Integer, List<Double>> ret = new HashMap<>();

        IntStream.range(0, rules.size())
                .forEach(i -> {
                    Rule rule = rules.get(i);
                    List<Double> val = rule.conditions()
                            .map(condition -> getConditionValue(condition, values))
                            .collect(Collectors.toList());
                    ret.put(i, val);
                });


        return ret;
    }


    public List<Double> defuzzification(final List<UnionOfFuzzySets> sets) {
        List<Double> y = new ArrayList<>();
        for(UnionOfFuzzySets unionOfFuzzySets : sets) {
            Double i1 = integral(unionOfFuzzySets, true);
            Double i2 = integral(unionOfFuzzySets, false);
            if(!i1.equals(0.0D) && !i2.equals(0.0D)){
                y.add(i1 / i2 );
            }else{
                y.add(0.0D);
            }
        }
        return y;
    }

    public Map<Integer, Double> aggregation(final Map<Integer, List<Double>> values) {
        return values.entrySet()
                .stream()
               /* .map(k -> k.getValue()
                        .stream()
                        .reduce(1.0D, (a, b) -> a*b)
                )*/
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> v.getValue().stream()
                                .max(Double::compareTo)
                                .orElse(0.0D)
                ));
    }


    public Map<Integer, ActivatedFuzzySet> activation(final Map<Integer, Double> values) {
        Map<Integer, ActivatedFuzzySet> ret = new HashMap<>();

        values.forEach((key, value) -> {
            Rule rule = rules.get(key);
            Conclusion conclusion = rule.getConclusion();
            ret.put(key, new ActivatedFuzzySet(conclusion.getTerm(), value * conclusion.getWeight()));
        });

        return ret;
    }

    public List<UnionOfFuzzySets> accumulation(final Map<Integer, ActivatedFuzzySet> values) {
        //Нужна ли аккумуляция?
        Map<Integer, UnionOfFuzzySets> unionsOfFuzzySets = new HashMap<>();
        int i = 0;
        for (Rule rule : rules) {
            Conclusion conclusion = rule.getConclusion();
            int index = conclusion.getVariable().getId();
            if (!unionsOfFuzzySets.containsKey(index)) {
                unionsOfFuzzySets.put(index, new UnionOfFuzzySets());
            }
            unionsOfFuzzySets.get(index).addFuzzySet(values.get(i));
            i++;
        }
        return new ArrayList<>(unionsOfFuzzySets.values());
    }

    private Double integral(FuzzySet fuzzySet, Boolean useX) {
        return integrate(0.0D, 100.0D, (x) -> useX ? x * fuzzySet.getValue(x) : fuzzySet.getValue(x));
    }

    public static Double integrate(Double a, Double b, DoubleUnaryOperator f) {
        Integer N = 10000;                    // precision parameter
        Double h = (b - a) / (N - 1);     // step size

        // 1/3 terms
        Double sum = 1.0 / 3.0 * (f.applyAsDouble(a) + f.applyAsDouble(b));

        // 4/3 terms
        for (Integer i = 1; i < N - 1; i += 2) {
            Double x = a + h * i;
            sum += 4.0 / 3.0 * f.applyAsDouble(x);
        }

        // 2/3 terms
        for (Integer i = 2; i < N - 1; i += 2) {
            Double x = a + h * i;
            sum += 2.0 / 3.0 * f.applyAsDouble(x);
        }

        return sum * h;
    }


    private Double getConditionValue(final Condition condition, final List<Double> values){
        return condition.getTerm()
                .getValue(values.get(condition.getVariable().getId()));
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
