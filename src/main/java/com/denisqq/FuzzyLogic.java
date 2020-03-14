package com.denisqq;

import com.denisqq.rule.Conclusion;
import com.denisqq.rule.Condition;
import com.denisqq.rule.Rule;
import com.denisqq.set.ActivatedFuzzySet;
import lombok.Builder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
public class FuzzyLogic {

    private List<Rule> rules;

    public FuzzyLogic(List<Rule> rules) {
        this.rules = rules;
    }

    public Double calc(final List<Double> values) {
        Map<Integer, List<Double>> fuz = fuzzification(values);
        Map<Integer, Double> aggregated = aggregation(fuz);
        List<ActivatedFuzzySet> activated = activation(aggregated);

        return defuzzification(aggregated.values(), activated);
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

        double ruleConclusion = activatedFuzzySets.stream()
                .mapToDouble(ActivatedFuzzySet::getTruthDegree)
                .sum();

        double agg = aggregated.stream()
                .mapToDouble(x -> x)
                .sum();

        double ret = 0.0D;

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
        try {
            return condition.getTerm()
                    .calculate(values.get(condition.getVariable().getId()));
        } catch (IndexOutOfBoundsException e) {
            return 0D;
        }
    }

    public FuzzyLogic addRule(Rule rule) {
        if(this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rule);
        return this;
    }

}
