package com.codility.app.solved.lesson12;

public class Lesson12_Task2 {

	// Lesson 12 - Euclidean algorithm: CommonPrimeDivisors
	// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {15, 10, 3};
		int[] B = {75, 30, 5};
		int result = sol.solution(A, B);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A, int[] B) {
			int N = A.length;

			// compute result
			int result = 0;
			for (int i = 0; i < N; i++) {
				if (hasSamePrimeDivisors(A[i], B[i])) {  // check if both A and B is dividend by same prime divisors
					result += 1;
				}
			}

			return result;
		}

		private boolean hasSamePrimeDivisors(int a, int b) {
			int gcd = getGCD(a, b);

			// a. check if a dividend by gcd's prime divisors
			while (a != 1) {
				int gcdA = getGCD(a, gcd);
				if (gcdA == 1) {  // exists other prime divisor
					return false;
				}
				a /= gcdA;
			}

			// b. check if b dividend by
			while (b != 1) {
				int gcdB = getGCD(b, gcd);
				if (gcdB == 1) {  // exists other prime divisor
					return false;
				}
				b /= gcdB;
			}

			// c. passed all conditions
			return true;
		}

		private int getGCD(int a, int b) {
			if (b == 0) {
				return a;
			}
			return getGCD(b, a % b);
		}

	}

}
