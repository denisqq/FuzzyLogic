package com.denisqq.rule;

import lombok.Builder;

@Builder
public class Variable {
    @Builder.Default
    private int id = 0;

    public Variable(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "id=" + id +
                '}';
    }
}
