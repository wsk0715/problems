package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_5585 {
	// 거스름돈 - B2
	// https://www.acmicpc.net/problem/5585
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = Integer.parseInt(sc.nextLine());

		System.out.println(sol(input));
	}

	private static int sol(int input) {
		int[] coins = {500, 100, 50, 10, 5, 1};

		int get = 1000 - input;

		int count = 0;
		for (int i = 0; i < coins.length; i++) {
			count += get / coins[i];
			get %= coins[i];
		}
		return count;
	}

}

