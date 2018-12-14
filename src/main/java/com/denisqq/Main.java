package com.denisqq;

import com.denisqq.functions.Trapezoid;
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
        List<Double> values = Arrays.asList(5D, 7D);
        Triangle onFoot = new Triangle()
                .setOpposite(0D)
                .setAdjacent(12D)
                .setHypotenuse(13D)
                .build();

        Triangle onCar = new Triangle()
                .setOpposite(8D)
                .setAdjacent(15D)
                .setHypotenuse(17D)
                .build();

        Trapezoid big = new Trapezoid(7.0D, 25.0D, 70.0D, 100.0D);
        Trapezoid small = new Trapezoid(0.0D, 8.0D, 50.0D, 150.0D);


        List<Rule> rules = new ArrayList<>();

        Rule r1 = new Rule();
        r1.setConditionList(Arrays.asList(
                new Condition(big,"Большая", new Variable(0)),
                new Condition(big,"Большая", new Variable(1))
        ));
        r1.setConclusion(
                new Conclusion(onCar,"На машине", new Variable(0),1.0D)
        );
        rules.add(r1);

        Rule r2 = new Rule();
        r2.setConditionList(Arrays.asList(
                new Condition(small,"Маленькая", new Variable(0)),
                new Condition(small,"Маленькая", new Variable(1))
        ));
        r2.setConclusion(
                new Conclusion(onFoot,"Пешком", new Variable(1),0.3D)
        );
        rules.add(r2);

        Rule r3 = new Rule();
        r3.setConditionList(Arrays.asList(
                new Condition(big,"Большая", new Variable(0)),
                new Condition(small,"Маленькая", new Variable(1))
        ));
        r3.setConclusion(
                new Conclusion(onFoot,"Бол->Мал", new Variable(2),0.5D)
        );
        rules.add(r3);

        Rule r4 = new Rule();
        r4.setConditionList(Arrays.asList(
                new Condition(small,"Маленькая", new Variable(0)),
                new Condition(big,"Большая", new Variable(1))
        ));
        r4.setConclusion(
                new Conclusion(onCar,"Мал->Бол", new Variable(3),0.5D)
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
