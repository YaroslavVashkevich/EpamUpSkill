package com.epam.upskill;

//8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
// Случай, когда самых длинных слов может быть несколько, не обрабатывать.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2_8 {
    public static void main(String[] args) {
        String str = "Called formerly looking quiet song spirit earnestly";
        String regEx = "(?U)\\w+";
        int max = 0;
        String maxWord = "";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
            String word = matcher.group();
            if (word.length() > max) {
                max = word.length();
                maxWord = word;
            }

        }

        System.out.println("Maximum word = " + "/" + maxWord + "/" + " Number of letters = " + max);
    }
}
