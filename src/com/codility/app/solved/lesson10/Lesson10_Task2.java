package com.codility.app.solved.lesson10;

public class Lesson10_Task2 {

	// Lesson 10 - Prime and composite numbers: MinPerimeterRectangle
	// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int N = 30;
		int result = sol.solution(N);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int N) {
			int minPerimeter = Integer.MAX_VALUE;
			long sqrt = (long) Math.sqrt(N);

			// find factor pairs
			for (int i = 1; i <= sqrt; i++) {
				if (N % i == 0) {
					int r = N / i;
					int perimeter = 2 * (i + r);
					minPerimeter = Math.min(minPerimeter, perimeter);
				}
			}

			return minPerimeter;
		}

	}

}
