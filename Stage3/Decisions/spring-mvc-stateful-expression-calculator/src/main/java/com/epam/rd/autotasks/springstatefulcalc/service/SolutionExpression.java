package com.epam.rd.autotasks.springstatefulcalc.service;

import com.epam.rd.autotasks.springstatefulcalc.model.SessionValues;

import java.util.Map;


    public class SolutionExpression {
        public static int solution(String expression){
            return LexemeAnalyzer.resolve(expression);
        }

        public static String expressionMapToString(SessionValues sessionValues){
            String expression = sessionValues.getExpression();

            for (Map.Entry<String,String> el : sessionValues.getValue().entrySet()){
                expression = expression.replaceAll(el.getKey(), el.getValue());
            }

            for (Map.Entry<String,String> el : sessionValues.getValue().entrySet()){
                expression = expression.replaceAll(el.getKey(), el.getValue());
            }
            return expression;
        }

        public static boolean isValidExpression(String expression){
            boolean result = true;
            char[] chars = expression.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] >= '0' && chars[i] <= '9'){
                    continue;
                }else if(chars[i] == ')' || chars[i] == '(' || chars[i] == '*'
                        || chars[i] == '/' || chars[i] == '+' || chars[i] == '-' || chars[i] == ' '){
                    continue;
                }
                result = false;
            }
            return result;
        }
    }

