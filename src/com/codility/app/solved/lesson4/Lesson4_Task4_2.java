package com.codility.app.solved.lesson4;

import java.util.HashSet;
import java.util.Set;

public class Lesson4_Task4_2 {

	// Lesson 4 - Counting Elements: MissingInteger
	// https://app.codility.com/programmers/lessons/4-counting_elements/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, 3, 6, 4, 1, 2};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		// other solution 1: using hashset
		public int solution(int[] A) {
			Set<Integer> hs = new HashSet<>();
			for (int e : A) {
				hs.add(e);
			}

			int t = 1;
			while (hs.contains(t)) {
				t += 1;
			}

			return t;
		}

	}

}
