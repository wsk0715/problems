package com.codility.app.solved.lesson9;

public class Lesson9_Task3 {

	// Lesson 9 - Maximum slice problem: MaxDoubleSliceSum
	// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {3, 2, -6, 4, 0};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;

			// calculate max sum subarray ending at each index from the left
			int[] maxEndingHere = new int[N];  // excluding last element
			for (int i = 1; i < N - 1; i++) {
				maxEndingHere[i] = Math.max(0, maxEndingHere[i - 1] + A[i]);
			}

			// calculate max sum subarray starting at each index from the right
			int[] maxStartingHere = new int[N];  // excluding first element
			for (int i = N - 2; i > 0; i--) {
				maxStartingHere[i] = Math.max(0, maxStartingHere[i + 1] + A[i]);
			}

			// find the maximum sum of any double slice
			int maxDoubleSliceSum = 0;
			for (int i = 1; i < N - 1; i++) {
				maxDoubleSliceSum = Math.max(maxDoubleSliceSum, maxEndingHere[i - 1] + maxStartingHere[i + 1]);
			}

			return maxDoubleSliceSum;
		}

	}

}
