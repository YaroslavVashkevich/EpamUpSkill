package com.epam.upskill;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом
// три различных операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова
// по длине; отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
// а в случае равенства – по алфавиту.

public class Task3_1 {
    public static void main(String[] args) {
        String text = "Это прекрасная природа средней полосы России. Здесь самая высокая плотность населения России." +
                "\n" +
                "Европейская часть России это бескрайние леса, полноводные реки, озёра, поля, луга." +
                "\n" +
                "В этой части находятся крупные промышленные города, образующие области. Например, Москва и Московская область, Владимир и Владимирская область и другие. Здесь большое количество заводов, фабрик, сельскохозяйственных комплексов." +
                "\n" +
                "Каждый год город принимает тысячи туристов со всего мира. Это удивительный город, его называют «музеем под открытым небом». Эрмитаж, Зимний дворец, Петергоф эти слова слышали все. Эрмитаж крупнейший музей мира, сокровищница мирового искусства. Зимний дворец резиденция русских царей." +
                "\n" +
                "В европейской части России находятся старинные русские города Ярославль, Кострома, Владимир, Углич, Ростов Великий, Суздаль. Они очень интересны своей историей и культурой. Все они входят в «Золотое кольцо России». Так называется и экскурсия, которая очень популярна и у русских, и у иностранцев.";

        System.out.println("\nСортировка абзацев по количеству предложений:\n");
        sortParagraph(text);
        System.out.println("\nСортировка слов в предложении по длине:\n");
        sortWord(text);
        System.out.println("\nСортировка лексем в предложении:\n");
        sortToken(text, 'а');
    }

    private static void sortParagraph(String text) {
        String[] paragraphs = text.split("\\n");
        int count = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String paragraph : paragraphs) {
            for (String s1 : paragraph.split("[.!?]")) {
                count++;
            }
            map.put(paragraph, count);
            count = 0;
        }
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    private static void sortWord(String text) {
        String[] sentences = text.split("[.!?]");
        for (String sentence : sentences) {
            sentence = sentence.strip().replaceAll("[,;:]", "");
            String[] words = sentence.split(" ");
            Arrays.sort(words, Comparator.comparing(String::length));
            System.out.println(Arrays.toString(words));
        }
    }

    private static void sortToken(String text, char letter) {
        if (text.indexOf(letter) != -1) {
            String[] sentences = text.split("([.!?]+)");
            for (String s : sentences) {
                String[] mass = s.split("(?U)\\W");
                for (int k = 0; k < mass.length; k++) {
                    if (mass[k].indexOf(letter) == -1) {
                        mass[k] = mass[k].replaceAll(".", "");
                    }
                }
                for (int k = 0; k < mass.length; k++) {
                    for (int j = 0; j < mass.length - 1; j++) {
                        if (count(mass[j], letter) > count(mass[j + 1], letter)) {
                            String temp = mass[j];
                            mass[j] = mass[j + 1];
                            mass[j + 1] = temp;
                        }
                    }
                }
                for (int k = 0; k < mass.length; k++) {
                    for (int j = 0; j < mass.length - 1; j++) {
                        if (count(mass[j], letter) == count(mass[j + 1], letter) && mass[j].compareTo(mass[j + 1]) > 0) {
                            String temp = mass[j];
                            mass[j] = mass[j + 1];
                            mass[j + 1] = temp;
                        }
                    }
                }
                int count = 1;
                for (String a : mass) {
                    if (!a.equals("")) {
                        if (count == mass.length) {
                            System.out.print(a);
                            System.out.println();
                        } else {
                            System.out.print(a + " ");
                        }
                    }
                    count++;
                }
            }
        } else {
            System.out.println("Лексемы отсутствуют.");
        }
    }

    private static int count(String str, char letter) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) {
                count++;
            }
        }
        return count;

    }
}
