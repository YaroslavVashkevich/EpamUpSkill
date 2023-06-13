package com.epam.upskill;

import java.util.Scanner;

// 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой.

public class Task4_9 {

	public static void main(String[] args) {

		double x = enterFromConsole("Input number x");
		double y = enterFromConsole("Input number y");
		double z = enterFromConsole("Input number z");
		double t = enterFromConsole("Input number t");

		area(x, y, z, t);
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

	public static void area(double x, double y, double z, double t) {
		double s1 = (x * y) / 2;
		double c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double p = (c + z + t) / 2;
		double s2 = Math.sqrt(p * (p - c) * (p - z) * (p - t));
		double s = s1 + s2;
		System.out.print("Area quadrangle = ");
		System.out.printf("%.1f", s);
	}
}