package com.codility.app.solved.lesson9;

public class Lesson9_Task2 {

	// Lesson 9 - Maximum slice problem: MaxSliceSum
	// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {3, 2, -6, 4, 0};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			// initialize currentMax and max with first element
			int currentMax = A[0];
			int max = A[0];

			// iterate from second element
			for (int i = 1; i < A.length; i++) {
				currentMax = Math.max(A[i], currentMax + A[i]);  // calculate currentMax including the current element
				max = Math.max(max, currentMax);  // update max if currentMax  is greater
			}

			return max;
		}

	}

}
