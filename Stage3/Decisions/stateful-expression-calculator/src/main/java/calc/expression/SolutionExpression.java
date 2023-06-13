package calc.expression;

import java.util.Map;

public class SolutionExpression {
    public static int solution(String expression){
        return LexemeAnalyzer.resolve(expression);
    }

    public static String expressionMapToString(Map<String,String> mapWithParameter){
        String expression = mapWithParameter.get("expression");

        for (Map.Entry<String,String> el : mapWithParameter.entrySet()){
            expression = expression.replaceAll(el.getKey(), el.getValue());
        }

        for (Map.Entry<String,String> el : mapWithParameter.entrySet()){
            expression = expression.replaceAll(el.getKey(), el.getValue());
        }
        return expression;
    }
}
