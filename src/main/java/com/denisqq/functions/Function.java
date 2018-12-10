package com.denisqq.functions;

public abstract class Function {

    private Double activatedValue;

    public Function() {
    }

    public Function(Double activatedValue) {
        this.activatedValue = activatedValue;
    }

    public abstract Double getValue(final Double x);

    public void setActivatedValue(Double val) {
        this.activatedValue = val;
    }

    public Double getActivatedValue(){
        return this.activatedValue;
    }

    @Override
    public String toString() {
        return "Function{" +
                "activatedValue=" + activatedValue +
                '}';
    }
}
