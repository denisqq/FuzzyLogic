package com.denisqq.rule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public Rule addCondition(Condition condition) {
        if(conditionList == null) {
            this.conditionList = new ArrayList<>();
        }
        conditionList.add(condition);

        return this;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "conditionList=" + conditionList +
                ", conclusion=" + conclusion +
                '}';
    }
}
