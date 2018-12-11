package com.denisqq.set;

import java.util.List;

public class UnionOfFuzzySets implements FuzzySet {

    private List<FuzzySet> fuzzySets;

    public UnionOfFuzzySets() {}

    public void addFuzzySet(FuzzySet fuzzySet) {
        fuzzySets.add(fuzzySet);
    }


    @Override
    public Double getValue(Double x) {
        return fuzzySets.stream()
                .map(item -> item.getValue(x)).max(Double::compare)
                .orElse(0.0);
    }




}
