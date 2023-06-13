package com.epam.upskill;

//5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.

public class Task2_5 {
    public static void main(String[] args) {
        String str = "Distance marked what considered raptures evening eyes sportsmen particular.";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }
        System.out.println("Letter a found - " + count);
    }
}
