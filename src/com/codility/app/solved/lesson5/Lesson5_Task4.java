package com.codility.app.solved.lesson5;

public class Lesson5_Task4 {

	// Lesson 5 - Prefix Sums: MinAvgTwoSlice
	// https://app.codility.com/programmers/lessons/5-prefix_sums/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {4, 2, 2, 5, 1, 5, 8};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;
			double minAvg = (A[0] + A[1]) / 2.0;
			int minIndex = 0;

			// length 2 slice
			for (int i = 0; i < N - 1; i++) {
				double avgLength2 = (A[i] + A[i + 1]) / 2.0;
				if (avgLength2 < minAvg) {
					minAvg = avgLength2;
					minIndex = i;
				}
			}

			// length 3 slice
			for (int i = 0; i < N - 2; i++) {
				double avgLength3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
				if (avgLength3 < minAvg) {
					minAvg = avgLength3;
					minIndex = i;
				}
			}

			return minIndex;
		}

	}

}
