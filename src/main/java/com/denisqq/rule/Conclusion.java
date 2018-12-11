package com.denisqq.rule;

import com.denisqq.set.FuzzySet;

import java.util.Objects;


public class Conclusion extends Statement{

    private Double weight;

    public Conclusion(FuzzySet term, String name, Variable variable, Double weight) {
        super(term, name, variable);
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Conclusion{" +
                "weight=" + weight +
                '}';
    }
}
