package com.codility.app.solved.lesson4;

import java.util.Arrays;

public class Lesson4_Task4 {

	// Lesson 4 - Counting Elements: MissingInteger
	// https://app.codility.com/programmers/lessons/4-counting_elements/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, 3, 6, 4, 1, 2};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			Arrays.sort(A);
			
			int e = 1;
			for (int i = 0; i < A.length; i++) {
				int current = A[i];
				if (current == e) {
					e += 1;
				}
			}

			return e;
		}

	}

}
