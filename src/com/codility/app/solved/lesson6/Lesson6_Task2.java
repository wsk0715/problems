package com.codility.app.solved.lesson6;

import java.util.Arrays;

public class Lesson6_Task2 {

	// Lesson 6 - Sorting: MaxProductOfThree
	// https://app.codility.com/programmers/lessons/6-sorting/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {-3, 1, 2, -2, 5, 6};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			Arrays.sort(A);

			// a. pos * pos * pos
			int n1 = 1;
			n1 *= A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

			// b. pos * neg * neg
			int n2 = 1;
			n2 *= A[A.length - 1] * A[0] * A[1];

			return Integer.max(n1, n2);
		}

	}

}
