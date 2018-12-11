package com.denisqq.rule;

public class Variable {
    private Integer id;

    public Variable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "id=" + id +
                '}';
    }
}
