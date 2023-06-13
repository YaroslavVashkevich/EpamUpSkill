package com.epam.upskill;

import java.util.Scanner;

/* 16. ћагическим квадратом пор€дка n называетс€ квадратна€ матрица размера nxn, составленна€ из чисел 1, 2, 3, ..., так,
что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой. ѕостроить такой квадрат. */

public class Task2_16 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int[][] mas = new int[n][n];

		if (n % 2 != 0) {
			odd(mas);
		} else if (n % 4 == 0) {
			evenFour(mas);
		} else {
			evenTwo(mas);
		}
		printArray(mas);
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

	public static void printArray(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "   ");
			}
			System.out.println("\n");
		}
	}

	public static void odd(int[][] mas) {
		int n = mas.length;
		int i = 0;
		int j = (n - 1) / 2;
		mas[i--][j++] = 1;
		for (int k = 2; k <= n * n; i--, j++, k++) {
			if (i < 0 && j > n - 1) {
				i += 2;
				j--;
			}
			if (i < 0) {
				i = n - 1;
			}
			if (j > n - 1) {
				j = 0;
			}
			if (mas[i][j] != 0) {
				i += 2;
				j--;
			}
			mas[i][j] = k;
		}

	}

	public static void evenFour(int[][] mas) {
		int n = mas.length;
		int k = 1;

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				mas[i][j] = k;
				k++;
			}
		}

		for (int i = 0; i < n; i += 4) {
			for (int j = 1; j < n; j += 4) {
				mas[i][j] = n * n + 1 - mas[i][j];
				mas[i + 3][j] = n * n + 1 - mas[i + 3][j];
				mas[i][j + 1] = n * n + 1 - mas[i][j + 1];
				mas[i + 3][j + 1] = n * n + 1 - mas[i + 3][j + 1];
			}
		}
		for (int i = 1; i < n; i += 4) {
			for (int j = 0; j < n; j += 4) {
				mas[i][j] = n * n + 1 - mas[i][j];
				mas[i + 1][j] = n * n + 1 - mas[i + 1][j];
				mas[i][j + 3] = n * n + 1 - mas[i][j + 3];
				mas[i + 1][j + 3] = n * n + 1 - mas[i + 1][j + 3];
			}
		}

	}

	public static void evenTwo(int[][] mas) {
		int n = mas.length;
		int[][] mas2 = even1(n - 2);
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				mas[i][j] = mas2[i - 1][j - 1] + 2 * (n - 1);
			}
		}
		int l = n / 2;
		int d = n * n + 1;

		mas[0][0] = 3 * l - 1;
		mas[0][n - 1] = 1;
		mas[n - 1][0] = d - 1;
		mas[n - 1][n - 1] = d - 3 * l + 1;

		int i, j;
		for (i = 1; i <= l - 2; i++) {
			mas[0][i] = 2 * i + 1;
		}
		for (j = 1; j <= l; j++) {
			mas[0][j + i - 1] = d - 2 * j;
		}
		for (j = 1; j < n - 1; j++) {
			mas[n - 1][j] = n * n + 1 - mas[0][j];
		}
		mas[1][0] = 2 * l - 1;
		for (i = 1; i <= l / 2; i++) {
			mas[i + 1][0] = 3 * l - 1 - i;
		}
		i--;
		for (j = 1; j <= l / 2 + 1; j++) {
			mas[i + j + 1][0] = d - 4 * l + 1 + j;
		}
		j--;
		for (int q = 1; q <= l / 2 - 1; q++, i++) {
			mas[i + j + q + 1][0] = 3 * l - 1 + q;
			mas[i + j + q + 2][0] = d - 2 * l - q;
		}

		for (i = 1; i < n - 1; i++) {
			mas[i][n - 1] = n * n + 1 - mas[i][0];
		}

	}

	public static int[][] even1(int n) {
		int[][] mas = new int[n][n];
		int k = 1;

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				mas[i][j] = k;
				k++;
			}
		}

		for (int i = 0; i < n; i += 4) {
			for (int j = 1; j < n; j += 4) {
				mas[i][j] = n * n + 1 - mas[i][j];
				mas[i + 3][j] = n * n + 1 - mas[i + 3][j];
				mas[i][j + 1] = n * n + 1 - mas[i][j + 1];
				mas[i + 3][j + 1] = n * n + 1 - mas[i + 3][j + 1];
			}
		}
		for (int i = 1; i < n; i += 4) {
			for (int j = 0; j < n; j += 4) {
				mas[i][j] = n * n + 1 - mas[i][j];
				mas[i + 1][j] = n * n + 1 - mas[i + 1][j];
				mas[i][j + 3] = n * n + 1 - mas[i][j + 3];
				mas[i + 1][j + 3] = n * n + 1 - mas[i + 1][j + 3];
			}
		}
		return mas;
	}

}