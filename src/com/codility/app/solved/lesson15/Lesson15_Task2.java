package com.codility.app.solved.lesson15;

import java.util.HashSet;
import java.util.Set;

public class Lesson15_Task2 {

	// Lesson 15 - Caterpillar method: CountDistinctSlices
	// https://app.codility.com/programmers/lessons/15-caterpillar_method/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int M = 6;
		int[] A = {3, 4, 5, 5, 2};
		int result = sol.solution(M, A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int M, int[] A) {
			// M: maximum value of elements of array A
			// A: integer arrya that contains elements to be sliced
			// compute count of distinct slice of array A.

			int N = A.length;
			long totalSlices = 0;
			int start = 0;
			Set<Integer> seen = new HashSet<>();

			for (int end = 0; end < N; end++) {
				// check if current element is already contained slice
				while (seen.contains(A[end])) {
					seen.remove(A[start]);
					start += 1;  // move start pointer
				}

				// add current element to slice
				seen.add(A[end]);
				totalSlices += (end - start + 1);

				// end condition
				if (totalSlices > 1_000_000_000) {
					return 1_000_000_000;
				}
			}

			return (int) totalSlices;
		}

	}

}
