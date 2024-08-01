package com.codility.app.solved.lesson4;

import java.util.Arrays;

public class Lesson4_Task2 {

	// Lesson 4 - Counting Elements: PermCheck
	// https://app.codility.com/programmers/lessons/4-counting_elements/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {4, 1, 3, 2};
		int resultA = sol.solution(A);
		System.out.printf("result A: %s\n", resultA);

		int[] B = {4, 1, 3};
		int resultB = sol.solution(B);
		System.out.printf("result B: %s\n", resultB);
	}

	static class Solution {

		public int solution(int[] A) {
			Arrays.sort(A);

			for (int i = 0; i < A.length; i++) {
				if (A[i] != i + 1) {
					return 0;
				}
			}

			return 1;
		}

	}

}
