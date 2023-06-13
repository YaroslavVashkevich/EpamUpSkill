package com.epam.upskill;

// 4. В строке найти количество чисел.

import java.util.Arrays;

public class Task1_4 {
    public static void main(String[] args) {
        String str = "  Called  234  formerly   1   looking  256quiet   song    578     spirit   2earnestly.  ";
        String[] str1 = str.split("\\D+");
        int count = 0;
        for (String number : str1) {
            if (!number.equals("")) {
                count++;
            }
        }
        System.out.println("Number of numbers per line - " + count);
    }
}
