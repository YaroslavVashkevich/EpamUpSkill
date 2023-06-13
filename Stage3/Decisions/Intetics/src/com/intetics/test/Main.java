package com.intetics.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String string = enterFromConsoleString("Input string of size N^2:");
        String word = enterFromConsoleString("Input word:");
        List<String> sequence = new ArrayList<>();
        int size = (int) Math.sqrt(string.length());
        char[] symbolFromString = string.toCharArray();
        char[] symbolFromWord = word.toCharArray();
        char[][] array = new char[size][size];

        int counterSymbolString = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = symbolFromString[counterSymbolString++];
            }
        }

        System.out.println("\n" + resultArray(array) + "\n");

        int counterSymbolWord = 0;
        int line = 0;
        int column = 0;
        while (counterSymbolWord < symbolFromWord.length) {
            out:
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (counterSymbolWord == 0 && symbolFromWord[counterSymbolWord] == array[i][j]) {
                        sequence.add("[" + i + "," + j + "]");
                        line = i;
                        column = j;
                        break out;
                    } else {
                        if (line != 0 && array[line - 1][column] == symbolFromWord[counterSymbolWord]) {
                            sequence.add("[" + (line - 1) + "," + column + "]");
                            line--;
                            break out;
                        }
                        if (line != array.length - 1 && array[line + 1][column] == symbolFromWord[counterSymbolWord]) {
                            sequence.add("[" + (line + 1) + "," + column + "]");
                            line++;
                            break out;
                        }
                        if (column != 0 && array[line][column - 1] == symbolFromWord[counterSymbolWord]) {
                            sequence.add("[" + line + "," + (column - 1) + "]");
                            column--;
                            break out;
                        }
                        if (column != array[i].length - 1 && array[line][column + 1] == symbolFromWord[counterSymbolWord]) {
                            sequence.add("[" + line + "," + (column + 1) + "]");
                            column++;
                            break out;
                        }
                    }
                }
            }
            counterSymbolWord++;
        }

        System.out.println(resultSequence(sequence));

    }

    public static String enterFromConsoleString(String message) {
        Scanner sc = new Scanner(System.in);
        String value;
        System.out.println(message);
        value = sc.nextLine();
        if (message == "Input string of size N^2:") {
            if (checkSize(value)) {
                return value;
            } else {
                System.out.println("Incorrect line size!!!");
                value = enterFromConsoleString("Input string of size N^2:");
            }
        }
        return value;
    }

    public static boolean checkSize(String value) {
        double size = Math.sqrt(value.length());
        return size % 2 == 0 || size % 1 == 0;
    }

    public static String resultSequence(List<String> sequence) {
        StringBuilder str = new StringBuilder();
        if (!sequence.isEmpty()) {
            for (String s : sequence) {
                str.append(s + "->");
            }
            str.delete(str.length() - 2, str.length());
            return str.toString();
        }
        return str.toString();
    }

    public static String resultArray(char[][] arrayResult) {
        StringBuilder str = new StringBuilder();
        if (arrayResult.length != 0) {
            str.append("[");
            for (int i = 0; i < arrayResult.length; i++) {
                for (int j = 0; j < arrayResult[i].length; j++) {
                    str.append("'" + arrayResult[i][j] + "',");
                }
                str.append('\n');
            }
            str.delete(str.length() - 2, str.length());
            str.append("]");
            return str.toString();
        }
        return str.toString();
    }
}
