package com.epam.upskill;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/* 4. Ќа плоскости заданы своими координатами n точек. Ќаписать метод(методы), определ€ющие, между какими из пар точек самое большое рассто€ние.
”казание.  оординаты точек занести в массив.*/

public class Task4_4 {

	public static void main(String[] args) {

		int n = enterFromConsole("Number of points n");
		int[][] mas = new int[n][2];

		initArray(mas);
		printArray(mas);
		System.out.println("Result");
		int[] result = maxDistance(mas);
		System.out.println("Max distanse between " + Arrays.toString(mas[result[0]]) + " and " + Arrays.toString(mas[result[1]]));
		
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

	public static void initArray(int[][] mas) {
		Random rand = new Random();
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				int x = rand.nextInt(15);
				mas[i][j] = x - 5;
			}
		}
	}

	public static void printArray(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static int[] maxDistance(int[][] mas) {
        double maxDistance = 0;
        double distance;
        int[] result = new int[2];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length; j++) {
                distance = distance(mas[i][0], mas[i][1], mas[j][0], mas[j][1]);
                if ( distance > maxDistance) {
                	maxDistance = distance;
                	result[0] = i;
                	result[1] = j;
                }
            }
        }
        return result;
    }
	
	private static double distance(int x1, int y1, int x2, int y2) {
        double xy = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return xy;
    }
	
}
