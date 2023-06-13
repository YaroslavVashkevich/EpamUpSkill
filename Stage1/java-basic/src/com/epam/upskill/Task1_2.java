package com.epam.upskill;

import java.util.Scanner;

// 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения) z=(b+√(b²+4ac))/2a - a³с + b⁻ ².

public class Task1_2 {
	public static void main(String[] args) {
		double a = enterFromConsole("Input number a");
		double b = enterFromConsole("Input namber b");
		double c = enterFromConsole("Input namber c");
		double z = (b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
		System.out.println("Z = " + z);

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

