package com.epam.upskill;

//2. Замените в строке все вхождения 'word' на 'letter'.

public class Task1_2 {
    public static void main(String[] args) {
        String str = "    Called    word      loowordking  word   song         word   earnestly.    ";
        str = str.replaceAll("word", "letter");
        System.out.println(str);
    }
}
