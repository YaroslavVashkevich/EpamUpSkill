package com.epam.upskill;

//2. В строке вставить после каждого символа 'a' символ 'b'.

public class Task2_2 {
    public static void main(String[] args) {
        String str = "Distance marked what considered raptures evening eyes sportsmen particular.";
        str = str.replaceAll("a", "ab");
        System.out.println(str);
    }
}
