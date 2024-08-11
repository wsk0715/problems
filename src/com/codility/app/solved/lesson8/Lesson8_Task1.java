package com.codility.app.solved.lesson8;

import java.util.HashMap;

public class Lesson8_Task1 {

	// Lesson 8 - Leader: Dominator
	// https://app.codility.com/programmers/lessons/8-leader/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			// exception handle; A is empty
			if (A.length == 0) {
				return -1;
			}

			HashMap<Integer, Integer> counts = new HashMap<>();
			int dominator = A[0];
			int maxCount = 0;

			// count the frequency of each element
			for (int i = 0; i < A.length; i++) {
				counts.put(A[i], counts.getOrDefault(A[i], 0) + 1);
				if (counts.get(A[i]) > maxCount) {
					maxCount = counts.get(A[i]);
					dominator = A[i];
				}
			}

			// check if the dominator exists
			if (maxCount <= A.length / 2) {
				return -1;
			}

			// return index of dominator
			for (int i = 0; i < A.length; i++) {
				if (A[i] == dominator) {
					return i;
				}
			}

			return -1;
		}

	}

}
