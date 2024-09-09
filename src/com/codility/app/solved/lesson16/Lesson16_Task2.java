package com.codility.app.solved.lesson16;

public class Lesson16_Task2 {

	// Lesson 16 - Greedy algorithms: TieRopes
	// https://app.codility.com/programmers/lessons/16-greedy_algorithms/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int K = 4;
		int[] A = {1, 2, 3, 4, 1, 1, 3};
		int result = sol.solution(K, A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int K, int[] A) {
			int N = A.length;

			int count = 0;
			int lastSum = A[0];

			for (int i = 1; i < N; i++) {
				if (lastSum >= K) {
					count += 1;
					lastSum = 0;
				}
				lastSum += A[i];
			}
			if (lastSum >= K) {
				count += 1;
			}

			return count;
		}

	}

}
