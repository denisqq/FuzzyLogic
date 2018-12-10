package com.denisqq.rule;

import com.denisqq.term.TermInfo;

public class Conclusion extends Statement{

    private Double weight;

    public Conclusion(Variable variable, TermInfo term, Double weight) {
        super(variable, term);
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
