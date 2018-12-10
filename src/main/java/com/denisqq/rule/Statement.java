package com.denisqq.rule;

import com.denisqq.term.TermInfo;

public class Statement {

    private Variable variable;
    private TermInfo term;

    public Statement(Variable variable, TermInfo term) {
        this.variable = variable;
        this.term = term;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public TermInfo getTerm() {
        return term;
    }

    public void setTerm(TermInfo term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "variable=" + variable +
                ", term=" + term +
                '}';
    }
}
