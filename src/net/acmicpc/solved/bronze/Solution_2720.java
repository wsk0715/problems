package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_2720 {
	// 세탁소 사장 동혁 - B3
	// https://www.acmicpc.net/problem/2720
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int times = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[times][4];

		for (int i = 0; i < times; i++) {
			int input = Integer.parseInt(sc.nextLine());
			int[] result = sol(input);
			for (int j = 0; j < 4; j++) {
				arr[i][j] = result[j];
			}
		}
		for (int i = 0; i < times; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}
	}

	private static int[] sol(int input) {
		int[] coins = new int[]{25, 10, 5, 1};
		int[] result = new int[4];

		for (int i = 0; i < coins.length; i++) {
			result[i] = input / coins[i];
			input %= coins[i];
		}
		return result;
	}

}
