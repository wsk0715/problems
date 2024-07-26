package com.codility.app.solved.lesson2;

import java.util.HashSet;
import java.util.Set;

public class Lesson2_Task2 {

	// Lesson 2 - Arrays: OddOccurrencesInArray
	// https://app.codility.com/programmers/lessons/2-arrays/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {9, 3, 9, 3, 9, 7, 9};
		int result = sol.solution(A);
		System.out.printf("result: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			if (A.length == 1) {
				return A[0];
			}

			Set<Integer> hs = new HashSet<>();
			for (int e : A) {
				if (hs.contains(e)) {
					hs.remove(e);
					continue;
				}
				hs.add(e);
			}

			return hs.iterator().next();
		}

	}

}
