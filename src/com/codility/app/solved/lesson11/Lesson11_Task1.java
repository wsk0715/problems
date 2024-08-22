package com.codility.app.solved.lesson11;

import java.util.Arrays;

public class Lesson11_Task1 {

	// Lesson 11 - Sieve of Eratosthenes: CountNonDivisible
	// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {3, 1, 2, 3, 6};
		int[] result = sol.solution(A);
		System.out.printf("result A: %s\n", Arrays.toString(result));
	}

	static class Solution {

		public int[] solution(int[] A) {
			int N = A.length;
			int max = 2 * N;

			// a. count the frequency of each number of A
			int[] counts = new int[max + 1];
			for (int num : A) {
				counts[num]++;
			}

			// b. compute number of non-divisors for each element
			int[] result = new int[N];

			for (int i = 0; i < N; i++) {
				int num = A[i];
				int divisorCount = 0;

				// find divisors
				for (int j = 1; j * j <= num; j++) {
					if (num % j == 0) {
						divisorCount += counts[j];

						if (j != num / j) {
							divisorCount += counts[num / j];
						}
					}
				}

				result[i] = N - divisorCount;
			}

			return result;
		}

	}

}
