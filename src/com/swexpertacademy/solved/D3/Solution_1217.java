package com.swexpertacademy.solved.D3;

import java.util.Scanner;

public class Solution_1217 {

	// 1217. 거듭 제곱 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14dUIaAAUCFAYD
	public static void main(String[] args) {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int n = sc.nextInt();
			int sq = sc.nextInt();

			System.out.printf("#%s %s\n", N, square(n, sq));
		}
	}

	private static int square(int n, int remain) {
		if (remain == 0) {
			return 1;
		}
		return n * square(n, remain - 1);
	}


	static Scanner sc = new Scanner(System.in);

}
