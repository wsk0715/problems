package com.codility.app.solved.lesson3;

public class Lesson3_Task1 {

	// Lesson 3 - Time Complexity: FrogJmp
	// https://app.codility.com/programmers/lessons/3-time_complexity/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int X = 10;
		int Y = 85;
		int D = 30;
		int result = sol.solution(X, Y, D);
		System.out.printf("result: %s\n", result);
	}

	static class Solution {

		public int solution(int X, int Y, int D) {
			double t = Y - X;

			return (int) Math.ceil(t / D);
		}

	}

}
