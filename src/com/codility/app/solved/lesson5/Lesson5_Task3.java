package com.codility.app.solved.lesson5;

import java.util.Arrays;

public class Lesson5_Task3 {

	// Lesson 5 - Prefix Sums: GenomicRangeQuery
	// https://app.codility.com/programmers/lessons/5-prefix_sums/
	public static void main(String[] args) {
		Solution sol = new Solution();

		String S = "CAGCCTA";
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		int[] result = sol.solution(S, P, Q);
		System.out.printf("result A: %s\n", Arrays.toString(result));
	}

	static class Solution {

		public int[] solution(String S, int[] P, int[] Q) {
			int l = S.length();

			// calculate prefix sum array
			int[] A = new int[l + 1];
			int[] C = new int[l + 1];
			int[] G = new int[l + 1];
			for (int i = 0; i < l; i++) {
				A[i + 1] = A[i];
				C[i + 1] = C[i];
				G[i + 1] = G[i];

				switch (S.charAt(i)) {
					case 'A':
						A[i + 1] += 1;
						break;
					case 'C':
						C[i + 1] += 1;
						break;
					case 'G':
						G[i + 1] += 1;
						break;
				}
			}

			int[] result = new int[P.length];
			for (int i = 0; i < P.length; i++) {
				int start = P[i];
				int end = Q[i] + 1;

				// case 1: A
				if (A[end] - A[start] > 0) {
					result[i] = 1;
					continue;
				}

				// case 2: C
				if (C[end] - C[start] > 0) {
					result[i] = 2;
					continue;
				}

				// case 3: G
				if (G[end] - G[start] > 0) {
					result[i] = 3;
					continue;
				}

				// case 4: T
				result[i] = 4;
			}

			return result;
		}

	}

}
