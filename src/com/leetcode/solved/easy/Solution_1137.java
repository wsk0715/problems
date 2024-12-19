package com.leetcode.solved.easy;

public class Solution_1137 {

	// 1137. N-th Tribonacci Number - Easy
	// https://leetcode.com/problems/n-th-tribonacci-number
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int n = 4;
		System.out.println(sol.tribonacci(n));
		// #case 2
		int n2 = 25;
		System.out.println(sol.tribonacci(n2));
	}

	static class Solution {

		public int tribonacci(int n) {
			// 1. Tribonacci Sequence란, T(n)이 다음과 같이 정의되는 수열이다.
			// 1-1. T(0) = 0, T(1) = 1, T(2) = 1
			// 1-2. T(n+3) = T(n) + T(n-1) + T(n+2), n >= 0
			// 2. n이 주어졌을 때, T(n)의 값을 반환하라.

			// 0 <= n <= 37 이다.


			if (n < 3) {
				if (n == 0) {
					return 0;
				} else {
					return 1;
				}
			}

			int[] dp = new int[n + 1];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
			}

			return dp[n];
		}

	}

}
