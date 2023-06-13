package com.epam.upskill;

import java.util.Scanner;

/*16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. 
    Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.*/

public class Task4_16 {

	public static void main(String[] args) {

		int n = enterFromConsole("Input number n");
		int result = sum(n);
        System.out.println("Sum number " + result);
        System.out.println("Even number = " + even(result));
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
	
	public static boolean odd(int numb) {
        while (numb > 0) {
            int tmp = numb % 10;


            if (tmp % 2 == 0) {
                return false;
            }
            numb /= 10;
        }
        return true;
    }

    public static int even(int numb) {
        int res = 0;
        while (numb > 0) {
            int tmp = numb % 10;


            if (tmp % 2 == 0) {
                res++;
            }
            numb /= 10;
        }
        return res;
    }

    public static int sum(int n) {
        int sum = 0;
        int first =(int)Math.pow(10, n - 1);
        for (int i = first; i < first * 10; i++) {
            if (odd(i)) {
                sum += i;
            }
        }
        return sum;
    }

}
