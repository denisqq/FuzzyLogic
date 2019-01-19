package com.denisqq.functions;


public class LTrapezoid implements Function {

    private Double a;
    private Double b;

    public LTrapezoid() {

    }

    public LTrapezoid(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    @Override
    public Double getValue(Double x) {
        Double val = 0.0D;

        if(x < a){
            val = 0.0D;
        } else if(a <= x && x <= b) {
            val = (x - a)/(b - a);
        } else if(x > b){
            val = 1.0D;
        }

        return val;
    }

    @Override
    public String toString() {
        return "LTrapezoid{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
