package com.denisqq;

import com.denisqq.rule.Condition;
import com.denisqq.rule.Rule;

import java.util.stream.Collectors;
import java.util.List;

public class Logic {

    public List<Double> fuzzification(final List<Rule> ruleList, final List<Double> values){
        return ruleList.stream()
                .flatMap(Rule::conditions)
                .map(condition -> getConditionValue(condition, values))
                .collect(Collectors.toList());
    }


    public void defuzzification(){

    }

    private Double getConditionValue(Condition condition, List<Double> values){

        return values.stream()
                /*.filter(val -> val.equals(condition.getVariable().getId()))*/
                .map(val -> condition.getTerm().getAccessoryFunc().getValue(val))
                .findFirst()
                .orElse(0.0D);
    }
}
