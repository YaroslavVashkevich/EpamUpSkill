package com.epam.rd.autotasks.springstatefulcalc.model;

import java.util.HashMap;
import java.util.Map;

public class SessionValues {
    private String expression;
    private Map<String,String> value = new HashMap<>();

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Map<String, String> getValue() {
        return value;
    }

    public void setValue(Map<String, String> value) {
        this.value = value;
    }
}
