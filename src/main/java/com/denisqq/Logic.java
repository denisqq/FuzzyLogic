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
import java.util.concurrent.atomic.DoubleAccumulator;
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

        //TODO Деффазификация нечеткого множества
        return null;
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
                        .reduce(1.0D, (a, b) -> a*b)
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
