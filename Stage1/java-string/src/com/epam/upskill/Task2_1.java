package com.epam.upskill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.

public class Task2_1 {
    public static void main(String[] args) {
        String str = "    Called                formerly      looking      quiet   song        spirit   earnestly.    ";
        String regEx = "\\s+";
        int max = 0;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String space = matcher.group();
            if (space.length() > max) {
                max = space.length();
            }
        }
        System.out.println("Maximum number of spaces - " + max);
    }
}

