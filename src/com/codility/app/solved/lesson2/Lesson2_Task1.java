package com.codility.app.solved.lesson2;

import java.util.Arrays;

public class Lesson2_Task1 {

	// Lesson 2 - Arrays: CyclicRotation
	// https://app.codility.com/programmers/lessons/2-arrays/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, 2, 3, 4};
		int K = 4;
		int[] result = sol.solution(A, K);
		System.out.printf("result: %s\n", Arrays.toString(result));
	}

	static class Solution {

		public int[] solution(int[] A, int K) {
			if (A.length == 0) {
				return A;
			}

			for (int i = 0; i < K; i++) {
				int tmp = A[A.length - 1];
				for (int j = A.length - 1; j > 0; j--) {
					A[j] = A[j - 1];
				}
				A[0] = tmp;
			}

			return A;
		}

	}

}
