package com.codility.app.solved.lesson17;

public class Lesson17_Task1 {

	// Lesson 17 - Dynamic programming: NumberSolitaire
	// https://app.codility.com/programmers/lessons/17-dynamic_programming/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, -2, 0, 9, -1, 2};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;

			int[] dp = new int[N];
			dp[0] = A[0];

			for (int i = 1; i < N; i++) {
				int prevMax = dp[i - 1];  // set initial value

				for (int j = 2; j <= 6; j++) {  // 6 sides of dice
					if (i - j >= 0) {
						prevMax = Math.max(prevMax, dp[i - j]);
					}
				}

				dp[i] = A[i] + prevMax;
			}

			return dp[N - 1];
		}

	}

}
