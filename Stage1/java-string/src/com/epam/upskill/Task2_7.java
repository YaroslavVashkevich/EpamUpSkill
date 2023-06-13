package com.epam.upskill;

//7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например,
// если было введено "abc cde def", то должно быть выведено "abcdef".

public class Task2_7 {
    public static void main(String[] args) {
        String str = "abc cde def";
        System.out.println(convert(str));
    }

    private static String convert(String str) {
        str = str.replaceAll("\\s+", "");
        StringBuilder str1 = new StringBuilder(str);
        for (int i = 0; i < str1.length(); i++) {
            String letter = String.valueOf(str1.charAt(i));
            int index;
            while ((index = str1.indexOf(letter, i + 1)) != -1)
                str1.deleteCharAt(index);
        }
        return str1.toString();
    }

}
