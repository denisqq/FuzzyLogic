package com.denisqq.rule;

import com.denisqq.functions.Function;

import java.util.Collections;
import java.util.List;

public class Condition extends Statement {
    private Condition(Function term, String name, Variable variable) {
        super(term, name, variable);
    }

    public static List<Condition> singletonCondition(Function function, String name) {
        return Collections.singletonList(new Condition(function, name, new Variable(0)));
    }

}
