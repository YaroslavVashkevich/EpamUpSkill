package com.epam.upskill;

import java.util.Scanner;

// 2. Вычислить значения функции на отрезке [а,b] c шагом h: y=x,x>2; y=-x,x<=2

public class Task3_2 {

	public static void main(String[] args) {
		double a = enterFromConsole("Input number a");
		double b = enterFromConsole("Input namber b");
		double h = enterFromConsole("Input namber h");
		double y;
		for (double x = a; x <= b; x += h) {

            if (x <= 2) {
                y = -x;
                System.out.println("Y = " + y);
            }
            if (x > 2) {
                y = x;
                System.out.println("Y = " + y);
            }     

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