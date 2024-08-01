package com.codility.app.solved.lesson4;

import java.util.HashSet;
import java.util.Set;

public class Lesson4_Task1 {

	// Lesson 4 - Counting Elements: FrogRiverOne
	// https://app.codility.com/programmers/lessons/4-counting_elements/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int X = 5;
		int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
		int result = sol.solution(X, A);
		System.out.printf("result: %s\n", result);
	}

	static class Solution {

		public int solution(int X, int[] A) {
			// Set of position where leaves have not fallen
			Set<Integer> hs = new HashSet<>();
			for (int i = 1; i <= X; i++) {
				hs.add(i);
			}
			System.out.println(hs);

			// A: time axis
			for (int i = 0; i < A.length; i++) {
				hs.remove(A[i]);

				if (hs.isEmpty()) {
					return i;
				}
			}

			return -1;
		}

	}

}
