package com.denisqq.functions;

public class Trapezoid implements Function {

    private Double a;
    private Double b;
    private Double c;
    private Double d;

    public Trapezoid() {
    }

    public Trapezoid(Double a, Double b, Double c, Double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    @Override
    public Double calculate(Double x) {
        Double val = 0.0D;

        if(x < a || x > b){
            val = 0.0D;
        } else if(a <= x && x <= b) {
            val = (x - a)/(b - a);
        } else if(b <= x && x <= c) {
            val = 1.0D;
        } else if(c <= x && x <= d){
            val = (d - x)/(d - c);
        }

        return val;
    }

    @Override
    public String toString() {
        return "Trapezoid{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
