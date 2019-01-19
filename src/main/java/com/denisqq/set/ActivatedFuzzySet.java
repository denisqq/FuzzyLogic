package com.denisqq.set;

import com.denisqq.functions.Function;

public class ActivatedFuzzySet {

    private Function fuzzySet;

    private Double truthDegree;

    public ActivatedFuzzySet(Function fuzzySet, Double truthDegree) {
        this.fuzzySet = fuzzySet;
        this.truthDegree = truthDegree;
    }

    public Function getFuzzySet() {
        return fuzzySet;
    }

    public void setFuzzySet(Function fuzzySet) {
        this.fuzzySet = fuzzySet;
    }

    public Double getTruthDegree() {
        return truthDegree;
    }

    public void setTruthDegree(Double truthDegree) {
        this.truthDegree = truthDegree;
    }

    @Override
    public String toString() {
        return "ActivatedFuzzySet{" +
                "fuzzySet=" + fuzzySet +
                ", truthDegree=" + truthDegree +
                '}';
    }
}
