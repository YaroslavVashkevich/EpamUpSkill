package com.epam.upskill;

import java.util.Scanner;

// 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.

public class Task4_6 {

	public static void main(String[] args) {

		int a = enterFromConsole("Input number a");
		int b = enterFromConsole("Input number b");
		int c = enterFromConsole("Input number c");
	
		primeNumber(a, b, c);
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

	public static void primeNumber(int a, int b, int c) {
		int nod = 0;
		int min = Math.min(Math.min(a, b), c);
		for (int i = min; i > 0; i--) {
            if ((a % i == 0) && (b % i == 0) && (c % i == 0)) {
                nod = i;
                break;
            }
        }
		if (nod == 1) {
            System.out.println("Mutually prime number");
        } else {
            System.out.println("Not mutually prime number");
        }
	}


}
