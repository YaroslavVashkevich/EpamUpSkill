package com.epam.upskill;

import java.util.Scanner;
import java.util.Random;

// 3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.

public class Task4_3 {

	public static void main(String[] args) {

		double a = enterFromConsole("Input side hexagon a");
		double area = area(a);
		System.out.printf("%.1f", area);
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

	public static double area(double a) {
		double area = (3 * Math.sqrt(3) * Math.pow(a, 2)) / 2;
		return area;
	}
}
