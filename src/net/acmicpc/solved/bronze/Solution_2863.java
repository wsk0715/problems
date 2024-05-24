package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_2863 {
	// 이게 분수? - B3
	// https://www.acmicpc.net/problem/2863
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] table = new int[4];
		for (int i = 0; i < 4; i++) {
			table[i] = sc.nextInt();
		}

		System.out.println(sol(table));
	}

	public static int sol(int[] table) {
		double max = calc(table);
		int rotates = 0;
		for (int i = 1; i < 4; i++) {
			table = rotate(table);
			double rotatedSum = calc(table);
			if (max < rotatedSum) {
				max = rotatedSum;
				rotates = i;
			}
		}
		return rotates;
	}

	private static double calc(int[] t) {
		double sum = (double) t[0] / t[2] + (double) t[1] / t[3];
		return sum;
	}

	public static int[] rotate(int[] t) {
		int[] table = {t[2], t[0], t[3], t[1]};
		return table;
	}

}

