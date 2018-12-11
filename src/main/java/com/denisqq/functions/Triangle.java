package com.denisqq.functions;

import com.denisqq.set.FuzzySet;

public class Triangle implements FuzzySet {

    private Double opposite;
    private Double adjacent;
    private Double hypotenuse;

    public Triangle() {

    }

    @Override
    public Double getValue(Double x) {
        Double val = 0.0D;

        if (x >= opposite && x < adjacent) {
            val = (x - opposite) / (adjacent- opposite);
        } else if (x > adjacent && x <= hypotenuse) {
            val = (hypotenuse - x) / (hypotenuse - adjacent);
        }

        return val;
    }

    public Triangle(Double opposite, Double adjacent, Double hypotenuse) {
        this.opposite = opposite;
        this.adjacent = adjacent;
        this.hypotenuse = hypotenuse;
    }

    public Double getOpposite() {
        return opposite;
    }

    public Triangle setOpposite(Double opposite) {
        this.opposite = opposite;
        return this;
    }

    public Double getAdjacent() {
        return adjacent;
    }

    public Triangle setAdjacent(Double adjacent) {
        this.adjacent = adjacent;
        return this;
    }

    public Double getHypotenuse() {
        return hypotenuse;
    }

    public Triangle setHypotenuse(Double hypotenuse) {
        this.hypotenuse = hypotenuse;
        return this;
    }

    public Triangle build(){
        return new Triangle(opposite, adjacent, hypotenuse);
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "opposite=" + opposite +
                ", adjacent=" + adjacent +
                ", hypotenuse=" + hypotenuse +
                '}';
    }
}
