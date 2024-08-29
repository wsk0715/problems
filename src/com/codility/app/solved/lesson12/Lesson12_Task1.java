package com.codility.app.solved.lesson12;

public class Lesson12_Task1 {

	// Lesson 12 - Euclidean algorithm: ChocolatesByNumbers
	// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int N = 10;
		int M = 4;
		int result = sol.solution(N, M);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int N, int M) {
			long gcd = getGCD(N, M);

			return (int) (N / gcd);  // Modular(Markov) chain with Euclidean algorithm
		}

		private long getGCD(int a, int b) {
			if (b == 0) {
				return a;
			}
			return getGCD(b, a % b);
		}

	}

}
