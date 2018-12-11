package com.denisqq;

import com.denisqq.functions.Triangle;
import com.denisqq.rule.Conclusion;
import com.denisqq.rule.Condition;
import com.denisqq.rule.Rule;
import com.denisqq.rule.Variable;
import com.denisqq.set.ActivatedFuzzySet;
import com.denisqq.set.UnionOfFuzzySets;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        List<Double> values = Arrays.asList(13D, 18D);
        Triangle small = new Triangle()
                .setOpposite(0D)
                .setAdjacent(15D)
                .setHypotenuse(15D)
                .build();

        Triangle big = new Triangle()
                .setOpposite(7D)
                .setAdjacent(20D)
                .setHypotenuse(20D)
                .build();

        List<Rule> rules = new ArrayList<>();

        Rule r1 = new Rule();
        r1.setConditionList(Arrays.asList(
                new Condition(big,"Большая", new Variable(0)),
                new Condition(big,"Большая", new Variable(1))
        ));
        r1.setConclusion(
                new Conclusion(big,"На машине",new Variable(0),1.0D)
        );
        rules.add(r1);

        Rule r2 = new Rule();
        r2.setConditionList(Arrays.asList(
                new Condition(small,"Маленькая", new Variable(0)),
                new Condition(small,"Маленькая", new Variable(1))
        ));
        r2.setConclusion(
                new Conclusion(small,"Пешком", new Variable(1),0.3D)
        );
        rules.add(r2);

        Rule r3 = new Rule();
        r3.setConditionList(Arrays.asList(
                new Condition(big,"Большая", new Variable(0)),
                new Condition(small,"Маленькая", new Variable(1))
        ));
        r3.setConclusion(
                new Conclusion(small,"Бол->Мал",new Variable(2),0.5D)
        );
        rules.add(r3);

        Rule r4 = new Rule();
        r4.setConditionList(Arrays.asList(
                new Condition(small,"Маленькая", new Variable(0)),
                new Condition(big,"Большая", new Variable(1))
        ));
        r4.setConclusion(
                new Conclusion(small,"Мал->Бол",new Variable(3),0.5D)
        );
        rules.add(r3);

        logic.setRules(rules);

        Map<Integer, List<Double>> fuz = logic.fuzzification(values);
        Map<Integer, Double> aggregated = logic.aggregation(fuz);
        Map<Integer, ActivatedFuzzySet> activated = logic.activation(aggregated);
        List<UnionOfFuzzySets> accumulated = logic.accumulation(activated);
        List<Double> defuz = logic.defuzzification(accumulated);

        System.out.println(logic.fuzzification(values) + "fuzzification");
        System.out.println(aggregated + " aggregation");
        System.out.println(activated + " activated");
        System.out.println(accumulated + " accumulated");
        System.out.println(defuz + " defuz");

    }


}
