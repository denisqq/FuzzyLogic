package com.denisqq.functions;

import com.denisqq.set.FuzzySet;

public class Trapezoid implements FuzzySet {

    private Double a;
    private Double b;
    private Double c;
    private Double d;


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
    public Double getValue(Double x) {
        Double ret = 0.0D;
        if (x <= a) {
            ret = 0.0D;
        }
        else if (x >= a && x < b) {
            ret = (x - a) / (b - a);
        }
        else if (x >= b && x <= c) {
            ret = 1.0D;
        }
        else if (x > c && x <= d) {
            ret = (d - x) / (d - c);
        }
        else if (d < x) {
            ret = 0.0D;
        }

        return ret;
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
