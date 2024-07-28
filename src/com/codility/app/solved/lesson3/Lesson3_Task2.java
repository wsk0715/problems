package com.codility.app.solved.lesson3;

public class Lesson3_Task2 {

	// Lesson 3 - Time Complexity: PermMissingElem
	// https://app.codility.com/programmers/lessons/3-time_complexity/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {2, 3, 1, 5};
		int result = sol.solution(A);
		System.out.printf("result: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int[] arr = new int[A.length + 2];

			for (int e : A) {
				arr[e] += 1;
			}

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 0) {
					return i;
				}
			}

			return 0;
		}

	}

}
