package com.denisqq.set;

public class ActivatedFuzzySet implements FuzzySet {

    private FuzzySet fuzzySet;

    private Double truthDegree;

    public ActivatedFuzzySet(FuzzySet fuzzySet, Double truthDegree) {
        this.fuzzySet = fuzzySet;
        this.truthDegree = truthDegree;
    }

    @Override
    public Double getValue(Double x) {
        return Math.min(fuzzySet.getValue(x), truthDegree);
    }
}
