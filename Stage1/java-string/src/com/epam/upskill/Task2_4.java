package com.epam.upskill;

//4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.

public class Task2_4 {
    public static void main(String[] args) {
        String word = "информатика";
        System.out.println(convert(word));
    }

    public static String convert(String word) {
        char[] array = word.toCharArray();
        String newWord = "";
        newWord = newWord.concat(String.copyValueOf(array, 7, 1))
                .concat(String.copyValueOf(array, 3, 2))
                .concat(String.copyValueOf(array, 7, 1));
        return newWord;
    }

}
