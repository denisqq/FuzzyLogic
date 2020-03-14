package com.denisqq.functions;

public class Triangle implements Function {

    private Double a;
    private Double b;
    private Double m;

    public Triangle() {
    }


    public Triangle(Double a, Double b, Double m) {
        this.a = a;
        this.b = b;
        this.m = m;
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

    public Double getM() {
        return m;
    }

    public void setM(Double m) {
        this.m = m;
    }

    @Override
    public Double calculate(Double x) {
        double val = 0.0D;

        if(x <= a){
            val = 0.0D;
        } else if((a < x) && (x <= m)){
            val = (x - a)/(m - a);
        } else if((m < x) && (x < b)) {
            val = (b - x)/(b - m);
        } else if(x >= b) {
            val = 0.0D;
        }

        return val;
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", m=" + m +
                '}';
    }
}
