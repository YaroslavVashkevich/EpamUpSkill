package com.epam.upskill;

import java.util.Scanner;

/*15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность (например, 1234, 5789).
   Для решения задачи использовать декомпозицию.*/

public class Task4_15 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		increase(n);
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

	public static void increase(int n) {
		int[] mas = new int[n];
		mas[0] = 1;
		while (mas[n - 1] < 9) {
			for (int i = 1; i < mas.length; i++) {
				mas[i] = mas[0] + i;
			}
			for (int a : mas) {
				System.out.print(a);
			}
			System.out.print(" ");
			mas[0]++;
		}
		
	}

}
