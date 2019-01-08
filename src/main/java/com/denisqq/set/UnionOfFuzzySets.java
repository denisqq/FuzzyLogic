package com.denisqq.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UnionOfFuzzySets implements FuzzySet {

    private List<FuzzySet> fuzzySets;

    public UnionOfFuzzySets() {}

    public void addFuzzySet(FuzzySet fuzzySet) {
        fuzzySets = Optional.ofNullable(fuzzySets).orElse(new ArrayList<>());
        fuzzySets.add(fuzzySet);
    }

    public List<FuzzySet> getFuzzySets() {
        return fuzzySets;
    }

    public void setFuzzySets(List<FuzzySet> fuzzySets) {
        this.fuzzySets = fuzzySets;
    }

    @Override
    public Double getValue(Double x) {
        return fuzzySets.stream()
                .map(item -> item.getValue(x))
                .max(Double::compare)
                .orElse(0.0);
    }


    @Override
    public String toString() {
        return "UnionOfFuzzySets{" +
                "fuzzySets=" + fuzzySets +
                '}';
    }
}
