package com.denisqq.functions;

import com.denisqq.set.FuzzySet;

public class RTrapezoid implements FuzzySet {

    private Double c;
    private Double d;

    public RTrapezoid() {
    }

    public RTrapezoid(Double c, Double d) {
        this.c = c;
        this.d = d;
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
        Double val = 0.0D;

        if(x > d) {
            val = 0.0D;
        } else if(c <= x && x <= d) {
            val = (d - x) / (d - c);
        } else if(x < c){
            val = 1.0D;
        }

        return val;
    }

    @Override
    public String toString() {
        return "RTrapezoid{" +
                "c=" + c +
                ", d=" + d +
                '}';
    }
}
