package com.denisqq.rule;

import com.denisqq.set.FuzzySet;

public class Condition extends Statement {

    public Condition(FuzzySet term, String name, Variable variable) {
        super(term, name, variable);
    }
}
