package com.epam.upskill;

//3. В строке найти количество цифр.

public class Task1_3 {
    public static void main(String[] args) {
        String str = " Called  234  formerly   1   looking  256quiet   song    578     spirit   2earnestly. ";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count++;
            }
        }
        System.out.println("Number in line - " + count);
    }
}