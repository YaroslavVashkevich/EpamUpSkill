package com.epam.upskill;

//6. Из заданной строки получить новую, повторив каждый символ дважды.

public class Task2_6 {
    public static void main(String[] args) {
        String str = "Distance marked what considered raptures";
        System.out.println(convert(str));
    }

    public static String convert(String str) {
        StringBuilder str1 = new StringBuilder(str);
        for (int i = 0; i < str1.length(); i = i + 2) {
            str1.insert(i, str1.charAt(i));
        }
        return str1.toString();
    }
}

