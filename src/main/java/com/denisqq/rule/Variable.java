package com.denisqq.rule;

import com.denisqq.set.FuzzySet;

import java.util.Set;

public class Variable {

    private Integer id;
    private Set<FuzzySet> terms;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<FuzzySet> getTerms() {
        return terms;
    }

    public void setTerms(Set<FuzzySet> terms) {
        this.terms = terms;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "id=" + id +
                ", terms=" + terms +
                '}';
    }
}
