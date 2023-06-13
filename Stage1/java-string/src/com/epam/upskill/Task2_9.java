package com.epam.upskill;

//9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
// Учитывать только английские буквы.

public class Task2_9 {
    public static void main(String[] args) {
        String str = "Conviction Blind Itself Trifling Parlors Regret Occasional Narrow.";
        int big = 0;
        int small = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                big++;
            }
            if ((Character.isLowerCase(str.charAt(i)))) {
                small++;
            }
        }
        System.out.println("Upper case = " + big + " Lower case = " + small);
    }

}

