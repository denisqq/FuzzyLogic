package com.denisqq.rule;

import com.denisqq.functions.Function;

public class Statement {

    private Function term;

    private String name;

    private Variable variable;

    public Statement(Function term, String name, Variable variable) {
        this.term = term;
        this.name = name;
        this.variable = variable;
    }


    public Function getTerm() {
        return term;
    }

    public void setTerm(Function term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }


    @Override
    public String toString() {
        return "Statement{" +
                "term=" + term +
                ", name='" + name + '\'' +
                ", variable=" + variable +
                '}';
    }
}
