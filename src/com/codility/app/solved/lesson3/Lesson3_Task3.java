package com.codility.app.solved.lesson3;

import java.util.Arrays;

public class Lesson3_Task3 {

	// Lesson 3 - Time Complexity: TapeEquilibrium
	// https://app.codility.com/programmers/lessons/3-time_complexity/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {3, 1, 2, 4, 3};
		int result = sol.solution(A);
		System.out.printf("result: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int totalSum = Arrays.stream(A).sum();
			int[] arr = new int[A.length];

			int currentSum = 0;
			for (int i = 1; i < A.length; i++) {
				int currentValue = A[i - 1];
				currentSum += currentValue;

				int subtract = totalSum - 2 * currentSum;
				arr[i] += subtract > 0 ? subtract : -subtract;
			}
			//			System.out.println(Arrays.toString(arr));

			int minValue = Integer.MAX_VALUE;
			for (int i = 1; i < arr.length; i++) {
				if (minValue > arr[i]) {
					minValue = arr[i];
				}
			}

			return minValue;
		}

	}

}
