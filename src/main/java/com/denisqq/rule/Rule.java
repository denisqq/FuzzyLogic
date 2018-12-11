package com.denisqq.rule;

import java.util.stream.Stream;
import java.util.List;

public class Rule {

    private List<Conclusion> conclusionList;
    private List<Condition> conditionList;

    public List<Conclusion> getConclusionList() {
        return conclusionList;
    }

    public void setConclusionList(List<Conclusion> conclusionList) {
        this.conclusionList = conclusionList;
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
    }

    public Stream<Condition> conditions() {
        return this.conditionList.stream();
    }

    @Override
    public String toString() {
        return "Rule{" +
                "conclusionList=" + conclusionList +
                ", conditionList=" + conditionList +
                '}';
    }
}
