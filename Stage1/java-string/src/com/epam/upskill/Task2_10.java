package com.epam.upskill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным
// или вопросительным знаком. Определить количество предложений в строке X.

public class Task2_10 {
    public static void main(String[] args) {
        String str = "Conviction blind itself trifling parlors regret occasional narrow." +
                " Help compact provision name?" +
                " Allowance admitting hastened roof unpleasing suspected!" +
                "Leave then post laughter perceive water invitation collected interested." +
                "Purse collecting provision absolute!" +
                "Up position speaking left?";
        String regEx = "\\w+[!.?]";
        int count = 0;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            count++;
        }
        System.out.println("Quantity = " + count);
    }
}
