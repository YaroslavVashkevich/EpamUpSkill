package com.epam.upskill;

import java.util.Scanner;

// 4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через отверстие.

public class Task2_4 {
	public static void main(String[] args) {
		double a = enterFromConsole("Input size a");
		double b = enterFromConsole("Input size b");
		double x = enterFromConsole("Input size x");
		double y = enterFromConsole("Input size y");
		double z = enterFromConsole("Input size z");
		
		if(x <= a && y <= b || x <= b && y <= a || x <= a && z <= b || x <= b && z <= a || y <= a && z <= b || y <= b && z < a) {
			System.out.println("OK.");
		} else {
			System.out.println("NOT!");
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
