package com.codility.app.solved.lesson6;

import java.util.Arrays;

public class Lesson6_Task4 {

	// Lesson 6 - Sorting: NumberOfDiscIntersections
	// https://app.codility.com/programmers/lessons/6-sorting/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, 5, 2, 1, 4, 0};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;
			long[] startPoints = new long[N];
			long[] endPoints = new long[N];

			// calculate start and end points for each disc
			for (int i = 0; i < N; i++) {
				startPoints[i] = (long) i - A[i];
				endPoints[i] = (long) i + A[i];
			}

			// sort the start and end points
			Arrays.sort(startPoints);
			Arrays.sort(endPoints);

			// count the number of intersections
			int intersections = 0;
			int activeDiscs = 0;
			int j = 0;
			for (int i = 0; i < N; i++) {
				while (j < N && startPoints[j] <= endPoints[i]) {
					activeDiscs += 1;
					j += 1;
				}
				activeDiscs--;  // remove current disc from active count
				intersections += activeDiscs;

				// check intersections exceed the limit
				if (intersections > 10_000_000) {
					return -1;
				}
			}

			return intersections;
		}

	}

}
