package com.codility.app.solved.lesson11;

import java.util.Arrays;

public class Lesson11_Task2 {

	// Lesson 11 - Sieve of Eratosthenes: CountSemiprimes
	// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int N = 26;
		int[] P = {1, 4, 16};
		int[] Q = {26, 10, 20};
		int[] result = sol.solution(N, P, Q);
		System.out.printf("result A: %s\n", Arrays.toString(result));
	}

	static class Solution {

		public int[] solution(int N, int[] P, int[] Q) {
			// a. generate the smallest prime factors up to N using the Sieve of Eratosthenes
			int[] minPrimeFactor = new int[N + 1];

			for (int i = 2; i * i <= N; i++) {
				if (minPrimeFactor[i] == 0) {  // a-1. if minPrimeFactor[i] == 0, i is prime number
					for (int k = i * i; k <= N; k += i) {  // a-2. iterate and mark all multipliers of i
						if (minPrimeFactor[k] == 0) {
							minPrimeFactor[k] = i;
						}
					}
				}
			}

			for (int i = 2; i <= N; i++) {
				if (minPrimeFactor[i] == 0) {
					minPrimeFactor[i] = i;  // i is prime
				}
			}

			// b. identify semiprimes up to N
			int[] isSemiPrime = new int[N + 1];

			for (int i = 2; i <= N; i++) {
				if (minPrimeFactor[i] != i) {  // b-1. check if i is not a prime number
					int firstFactor = minPrimeFactor[i];
					int secondFactor = i / firstFactor;

					if (minPrimeFactor[secondFactor] == secondFactor) {  // b-2. second factor is also prime
						isSemiPrime[i] = 1;  // b-3. i is a semiprime
					}
				}
			}
			
			// c. compute prefix sums of semiprimes to answer queries efficiently
			int[] prefixSum = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				prefixSum[i] = prefixSum[i - 1] + isSemiPrime[i];
			}

			int M = P.length;
			int[] result = new int[M];

			for (int i = 0; i < M; i++) {
				int from = P[i];
				int to = Q[i];
				result[i] = prefixSum[to] - prefixSum[from - 1];
			}

			return result;
		}

	}

}
