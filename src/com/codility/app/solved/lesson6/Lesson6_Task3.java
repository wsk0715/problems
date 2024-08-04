package com.codility.app.solved.lesson6;

import java.util.Arrays;

public class Lesson6_Task3 {

	// Lesson 6 - Sorting: Triangle
	// https://app.codility.com/programmers/lessons/6-sorting/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {10, 2, 5, 1, 8, 20};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			Arrays.sort(A);

			for (int i = 0; i < A.length - 2; i++) {
				long a = A[i];
				long b = A[i + 1];
				long c = A[i + 2];

				if (a + b > c && b + c > a && c + a > b) {
					return 1;
				}
			}

			return 0;
		}

	}

}
