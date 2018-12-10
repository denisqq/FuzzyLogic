package com.denisqq.term;

import com.denisqq.functions.Function;

public class TermInfo {

    private String name;
    private Function accessoryFunc;

    public TermInfo() {
    }

    public TermInfo(String name, Function accessoryFunc) {
        this.name = name;
        this.accessoryFunc = accessoryFunc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Function getAccessoryFunc() {
        return accessoryFunc;
    }

    public void setAccessoryFunc(Function accessoryFunc) {
        this.accessoryFunc = accessoryFunc;
    }

    @Override
    public String toString() {
        return "TermInfo{" +
                "name='" + name + '\'' +
                ", accessoryFunc=" + accessoryFunc +
                '}';
    }
}
