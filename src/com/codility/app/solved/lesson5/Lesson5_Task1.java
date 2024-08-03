package com.codility.app.solved.lesson5;

public class Lesson5_Task1 {

	// Lesson 5 - Prefix Sums: PassingCars
	// https://app.codility.com/programmers/lessons/5-prefix_sums/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {0, 1, 0, 1, 1};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int r = 0;  // result, passing cars
			int count = 0;  // cars behind

			// 0 represents a car traveling east,
			// 1 represents a car traveling west.
			for (int car : A) {
				if (car == 0) {  // a. traveling east
					count += 1;
				} else {  // b. traveling west
					r += count;
				}

				if (r > 1_000_000_000) {  // c. breaking condition
					return -1;
				}
			}

			return r;
		}

	}

}
