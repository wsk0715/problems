package com.codility.app.solved.lesson10;

import java.util.ArrayList;
import java.util.Collections;

public class Lesson10_Task4 {

	// Lesson 10 - Prime and composite numbers: Peaks
	// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;

			// a. find peaks and compute prefix sums
			int[] peaks = new int[N];
			int[] prefixPeaks = new int[N];

			for (int i = 1; i < N - 1; i++) {
				if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
					peaks[i] = 1;
				}
			}

			prefixPeaks[0] = peaks[0];

			for (int i = 1; i < N; i++) {
				prefixPeaks[i] = prefixPeaks[i - 1] + peaks[i];
			}

			// b. find all divisors of N
			ArrayList<Integer> divisors = new ArrayList<>();

			for (int i = 1; i * i <= N; i++) {
				if (N % i == 0) {
					divisors.add(i);
					if (i != N / i) {
						divisors.add(N / i);
					}
				}
			}
			divisors.sort(Collections.reverseOrder());

			// c. check if blocks can be formed with at least one peak
			for (int K : divisors) {
				int blockSize = N / K;
				boolean valid = true;

				for (int i = 0; i < K; i++) {
					int left = i * blockSize;
					int right = (i + 1) * blockSize - 1;
					int peaksInBlock = prefixPeaks[right] - (left > 0 ? prefixPeaks[left - 1] : 0);

					if (peaksInBlock == 0) {
						valid = false;
						break;
					}
				}
				if (valid) {
					return K;
				}
			}

			return 0;
		}

	}

}
