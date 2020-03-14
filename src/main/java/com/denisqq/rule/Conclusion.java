package com.denisqq.rule;

import com.denisqq.functions.Function;


public class Conclusion extends Statement {

    private Double weight;

    private Conclusion(Function term, String name, Variable variable, Double weight) {
        super(term, name, variable);
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static Conclusion createConclusion(Function function, String name, Double weight) {
        return new Conclusion(function, name, new Variable(0), weight);
    }

    @Override
    public String toString() {
        return "Conclusion{" +
                "weight=" + weight +
                '}';
    }
}
