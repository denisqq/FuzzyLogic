package com.denisqq;


import com.denisqq.functions.Function;
import com.denisqq.functions.Triangle;
import com.denisqq.rule.Conclusion;
import com.denisqq.rule.Condition;
import com.denisqq.rule.Rule;
import com.denisqq.rule.Variable;
import com.denisqq.term.TermInfo;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();

        Function big = new Triangle(15D)
                .setAdjacent(20D)
                .setOpposite(20D)
                .setHypotenuse(20D)
                .build();
        Function small = new Triangle(0D)
                .setAdjacent(10D)
                .setHypotenuse(10D)
                .setOpposite(10D)
                .build();

        Set<TermInfo> terms = new HashSet<>();

        terms.add(new TermInfo("не большая", small));
        terms.add(new TermInfo("большая", big));

        Variable var1 = new Variable();

        Set<Condition> conditions = new HashSet<>();
        Set<Conclusion> conclusions = new HashSet<>();

        Rule r1 = new Rule();
        /*conditions.add(new Condition())*/
    }

}
