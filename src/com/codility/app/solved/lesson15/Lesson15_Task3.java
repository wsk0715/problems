package com.codility.app.solved.lesson15;

import java.util.Arrays;

public class Lesson15_Task3 {

	// Lesson 15 - Caterpillar method: CountTriangles
	// https://app.codility.com/programmers/lessons/15-caterpillar_method/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {10, 2, 5, 1, 8, 12};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;

			// exception case; less than 3 elements
			if (N < 3) {
				return 0;
			}

			Arrays.sort(A);
			long count = 0;

			for (int i = N - 1; i >= 2; i--) {
				int P = 0;
				int Q = i - 1;

				while (P < Q) {
					// check if satisfied triangle condition
					if ((long) A[P] + (long) A[Q] > (long) A[i]) {
						count += (Q - P);  // elements from P to Q-1 are valid
						Q -= 1;  // move Q to left
					} else {  // not satisfied
						P += 1;  // move P to right
					}

					// end condition
					if (count > 1_000_000_000L) {
						return 1_000_000_000;
					}
				}
			}

			return (int) count;
		}

	}

}
