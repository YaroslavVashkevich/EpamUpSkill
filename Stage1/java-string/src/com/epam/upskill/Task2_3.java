package com.epam.upskill;

//3. Проверить, является ли заданное слово палиндромом.

public class Task2_3 {
    public static void main(String[] args) {
        String word1 = "топот", word2 = "казак", word3 = "топор", word4 = "шалаш";
        System.out.println("   " + word1 + "      " + word2 + "      " + word3 + "        " + word4);
        System.out.println(check(word1) + "  " + check(word2) + "  " + check(word3) + "  " + check(word4));
    }
    public static String check(String word){
        String result;
        StringBuilder str = new StringBuilder(word);
        if (str.toString().equals(str.reverse().toString())) {
            result = "Палиндром";
        }else {
            result = "Не палиндром";
        }
        return result;
    }

    }

