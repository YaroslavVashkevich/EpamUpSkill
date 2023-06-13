package com.epam.upskill;

import java.util.Scanner;

// 5. Вычислить значение функции: F(x) = x2 = x²-3x+9, если x<=3, F(x) = 1/(x³ + 6), если x>3.

public class Task2_5 {
	public static void main(String[] args) {
		double x = enterFromConsole("Input number x");
		if(x <= 3) {
			double fx = x*x - 3*x - 9;
			System.out.println("F(x) = " + fx);
			}
		if(x > 3) {
			double fx = 1/(Math.pow(x, 3) + 6);
			System.out.println("F(x) = " + fx);
		}
		

	}

	public static double enterFromConsole(String message) {
		Scanner sc = new Scanner(System.in);
		double value;
		System.out.println(message);
		while (!sc.hasNextDouble()) {
			sc.nextLine();
			System.out.println(message);
		}
		value = sc.nextDouble();
		return value;

	}
}
