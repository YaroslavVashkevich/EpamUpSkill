package com.epam.upskill;

//5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
// Крайние пробелы в строке удалить.

public class Task1_5 {
    public static void main(String[] args) {
        String str = "    Called    formerly      looking  quiet   song         spirit   earnestly.    ";
        str = str.strip();
        str = str.replaceAll("\\s+", " ");
        System.out.println(str);
    }
}
