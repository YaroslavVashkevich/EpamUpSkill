package com.epam.upskill;

import java.util.Arrays;
import java.util.Scanner;

//10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого являются цифры числа N.

public class Task4_10 {

    public static void main(String[] args) {
    	
    	int n = enterFromConsole("Input number n");
        System.out.println(Arrays.toString(mas(n)));
    }
    
    public static int enterFromConsole(String message) {
		Scanner sc = new Scanner(System.in);
		int value;
		System.out.println(message);
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println(message);
		}
		value = sc.nextInt();
		return value;
	}
    
    public static int[] mas(int n) {
        int[] mas = new int[String.valueOf(n).length()];
        for (int i = mas.length - 1; i >= 0; i--) {
            mas[i] = n % 10;
            n = n / 10;
        }
        return mas;
    }
}