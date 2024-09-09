package com.codility.app.solved.lesson16;

public class Lesson16_Task1 {

	// Lesson 16 - Greedy algorithms: MaxNonoverlappingSegments
	// https://app.codility.com/programmers/lessons/16-greedy_algorithms/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, 3, 7, 9, 9};
		int[] B = {5, 6, 8, 9, 10};
		int result = sol.solution(A, B);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A, int[] B) {
			int N = A.length;
			if (N == 0) {
				return 0;
			}

			int count = 1;
			int lastEnd = B[0];

			for (int i = 1; i < N; i++) {
				if (A[i] > lastEnd) {
					count += 1;
					lastEnd = B[i];
				}
			}
			return count;
		}

	}

}
