package com.epam.upskill;

import java.util.Scanner;

// 3. Вычислить значение выражения по формуле (все переменные принимают действительные значения): ((sin x + cos y) / (cos x - sin y)) * tg xy.

public class Task1_3 {
	public static void main(String[] args) {
		double x = enterFromConsole("Input number x");
		double y = enterFromConsole("Input namber y");
		double z = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
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
