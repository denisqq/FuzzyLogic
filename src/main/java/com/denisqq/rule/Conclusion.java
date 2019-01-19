package com.denisqq.rule;

import com.denisqq.functions.Function;


public class Conclusion extends Statement{

    private Double weight;

    public Conclusion(Function term, String name, Variable variable, Double weight) {
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
