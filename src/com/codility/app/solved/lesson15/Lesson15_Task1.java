package com.codility.app.solved.lesson15;

import java.util.HashSet;
import java.util.Set;

public class Lesson15_Task1 {

	// Lesson 15 - Caterpillar method: AbsDistinct
	// https://app.codility.com/programmers/lessons/15-caterpillar_method/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {-5, -3, -1, 0, 3, 6};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			// A: integer array that contains non-decreasing numbers
			// compute absolute distinct count

			Set<Integer> hs = new HashSet<>();
			for (int n : A) {
				hs.add(n > 0 ? n : -n);
			}

			return hs.size();
		}

	}

}
