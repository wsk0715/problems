package com.codility.app.solved.lesson10;

public class Lesson10_Task1 {

	// Lesson 10 - Prime and composite numbers: CountFactors
	// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int N = 24;
		int result = sol.solution(N);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int N) {
			int count = 0;
			long sqrt = (long) Math.sqrt(N);

			for (int i = 1; i <= sqrt; i++) {
				if (N % i == 0) {
					count += 1;

					// check if i == N/i
					if (i != N / i) {
						count += 1;
					}
				}
			}

			return count;
		}

	}

}
