package com.denisqq.rule;

import java.io.Serializable;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.List;

public class Rule {

    private List<Condition> conditionList;
    private Conclusion conclusion;

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
    }

    public Stream<Condition> conditions() {
        return this.conditionList.stream();
    }

    public Conclusion getConclusion() {
        return conclusion;
    }

    public void setConclusion(Conclusion conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "conditionList=" + conditionList +
                ", conclusion=" + conclusion +
                '}';
    }
}
