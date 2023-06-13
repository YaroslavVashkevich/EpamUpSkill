package com.epam.upskill;

import java.util.Scanner;

/* 13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
  Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для решения задачи использовать декомпозицию.*/

public class Task4_13 {

    public static void main(String[] args) {
    	
    	int n = enterFromConsole("Input number n");
    	twin(n);
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
    
    public static void twin(int n) {
    	for (int i = n; i < 2 * n - 2; i++) {
            if (simple(i) && simple(i + 2)) {
                System.out.println(i + " and " + (i + 2));
            }
        } 
    }
    public static boolean simple(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
            	return false;
            }
        }
        return true;
    }
    
}
