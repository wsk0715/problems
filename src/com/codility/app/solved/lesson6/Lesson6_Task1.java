package com.codility.app.solved.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Lesson6_Task1 {

	// Lesson 6 - Sorting: Distinct
	// https://app.codility.com/programmers/lessons/6-sorting/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {2, 1, 1, 2, 3, 1};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			Set<Integer> hs = new HashSet<>();
			for (int i : A) {
				hs.add(i);
			}

			return hs.size();
		}

	}

}
