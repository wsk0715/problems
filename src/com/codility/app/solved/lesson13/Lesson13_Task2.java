package com.codility.app.solved.lesson13;

import java.util.Arrays;

public class Lesson13_Task2 {

	// Lesson 13 - Fibonacci numbers: Ladder
	// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {4, 4, 5, 5, 1};
		int[] B = {3, 2, 4, 3, 1};
		int[] result = sol.solution(A, B);
		System.out.printf("result A: %s\n", Arrays.toString(result));
	}

	static class Solution {

		public int[] solution(int[] A, int[] B) {
			int N = A.length;
			int[] result = new int[N];

			// a. find maximum value of A
			int maxA = 0;
			for (int n : A) {
				if (n > maxA) {
					maxA = n;
				}
			}

			// b. pre-compute dp array
			long[] dp = new long[maxA + 1];
			dp[0] = 1;
			if (maxA >= 1) {
				dp[1] = 1;
			}

			int MOD_VALUE = 1 << 30;  // 2^30
			for (int i = 2; i < dp.length; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) & (MOD_VALUE - 1);  // n & (m-1) equals to n mod m
			}

			// c. compute result
			for (int i = 0; i < N; i++) {
				int M = A[i];
				int P = B[i];
				long mask = (1L << P) - 1;  // equals to 2^P - 1

				// since dp[M] is already mod by 2^30(and P <= 30), can safely use bitmasking
				result[i] = (int) (dp[M] & mask);
			}

			return result;
		}

	}

}
