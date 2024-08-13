package com.codility.app.solved.lesson9;

public class Lesson9_Task1 {

	// Lesson 9 - Maximum slice problem: MaxProfit
	// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			// exception handle; A is empty
			if (A.length == 0) {
				return 0;
			}

			int minPrice = A[0];  // minimum price seen so far
			int maxProfit = 0;  // maximum profit found so far

			// find the maximum profit
			for (int i = 1; i < A.length; i++) {
				// calculate the profit
				int currentProfit = A[i] - minPrice;
				maxProfit = Math.max(maxProfit, currentProfit);
				minPrice = Math.min(minPrice, A[i]);
			}

			return maxProfit;
		}

	}

}
