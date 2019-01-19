package com.denisqq;

import com.denisqq.rule.Conclusion;
import com.denisqq.rule.Condition;
import com.denisqq.rule.Rule;
import com.denisqq.set.ActivatedFuzzySet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Logic {

    private List<Rule> rules;

    public Logic() {
    }

    public Logic(List<Rule> rules) {
        this.rules = rules;
    }

    public Double calc(final List<Double> values) {

        Map<Integer, List<Double>> fuz = fuzzification(values);
        Map<Integer, Double> aggregated = aggregation(fuz);
        List<ActivatedFuzzySet> activated = activation(aggregated);
        Double ret = defuzzification(aggregated.values(), activated);


        return ret;
    }


    //Вводим нечеткость с помощью функций истинности
    private Map<Integer, List<Double>> fuzzification(final List<Double> values){
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

    //Вычисляем центр масс
    private Double defuzzification(final Collection<Double> aggregated, final List<ActivatedFuzzySet> activatedFuzzySets) {

        Double ruleConclusion = activatedFuzzySets.stream()
                .mapToDouble(ActivatedFuzzySet::getTruthDegree)
                .sum();

        Double agg = aggregated.stream()
                .mapToDouble(x -> x)
                .sum();

        Double ret = 0.0D;

        if(agg != 0) {
            ret = ruleConclusion / agg;
        }


        return ret;
    }

    //Вычисляем предпосылки выполнения правил
    private Map<Integer, Double> aggregation(final Map<Integer, List<Double>> values) {
        return values.entrySet()
                .stream()
//                .map(k -> k.getValue()
//                        .stream()
//                        .reduce(1.0D, (a, b) -> a*b)
//                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> v.getValue().stream()
                                .reduce(1.0D, (a, b) -> a * b)
                ));
    }

    //Вычисляем степень выполнения правил и следствие правил
    private List<ActivatedFuzzySet> activation(final Map<Integer, Double> values) {
        List<ActivatedFuzzySet> ret = new ArrayList<>();

        values.forEach((key, value) -> {
            Rule rule = rules.get(key);
            Conclusion conclusion = rule.getConclusion();
            ret.add(new ActivatedFuzzySet(conclusion.getTerm(), value * conclusion.getWeight()));
        });

        return ret;
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
