package com.codility.app.solved.lesson5;

public class Lesson5_Task2 {

	// Lesson 5 - Prefix Sums: CountDiv
	// https://app.codility.com/programmers/lessons/5-prefix_sums/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int A = 6;
		int B = 11;
		int K = 2;
		int result = sol.solution(A, B, K);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int A, int B, int K) {
			if (A == 0) {  // handle: the case when A is 0
				return (B / K) + 1;
			}

			return (B / K) - ((A - 1) / K);
		}

	}

}
