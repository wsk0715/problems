package com.codility.app.solved.lesson1;

public class Lesson1_Task1 {

	// Lesson 1 - Iterations: Binary Gap
	// https://app.codility.com/programmers/lessons/1-iterations/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int input = 1041;
		int result = sol.solution(input);
		System.out.printf("result: %d\n", result);
	}

	static class Solution {

		public int solution(int N) {
			String bin = Integer.toBinaryString(N);
			//			System.out.println(bin);

			int longestGap = 0;
			int currentGap = 0;
			boolean counting = false;

			for (char c : bin.toCharArray()) {
				if (c == '1') {
					if (counting) {
						longestGap = Math.max(longestGap, currentGap);
						currentGap = 0;
					}
					counting = true;
				} else if (counting) {
					currentGap += 1;
				}
			}

			return longestGap;
		}

	}

}
