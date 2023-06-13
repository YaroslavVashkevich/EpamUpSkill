package com.epam.upskill;

import java.util.Arrays;

//1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.

public class Task1_1 {
    public static void main(String[] args) {
        String[] array = {"camelCase", "snakeCase", "bookCase", "peopleCase"};
        for (int i = 0; i < array.length; i++) {
            array[i] = transform(array[i]);
        }
        System.out.println(Arrays.toString(array));
    }

    public static String transform(String str) {
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                str1.append("_").append(Character.toLowerCase(str.charAt(i)));
            } else {
                str1.append(str.charAt(i));
            }
        }
        return str1.toString();
    }
}
