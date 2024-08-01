package com.codility.app.solved.lesson4;

import java.util.Arrays;

public class Lesson4_Task3 {

	// Lesson 4 - Counting Elements: MaxCounters
	// https://app.codility.com/programmers/lessons/4-counting_elements/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int N = 5;
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		int[] result = sol.solution(N, A);
		System.out.printf("result A: %s\n", Arrays.toString(result));
	}

	static class Solution {

		public int[] solution(int N, int[] A) {
			int[] arr = new int[N];

			int floorValue = 0;
			int currentMaxValue = 0;
			for (int e : A) {
				if (e <= N) {  // case 1: increase operation
					int idx = e - 1;  // index optimize

					// *lazy update of max counter
					if (arr[idx] < floorValue) {
						arr[idx] = floorValue;
					}

					// increase operation
					arr[idx] += 1;

					// check and update current max value
					if (arr[idx] > currentMaxValue) {
						currentMaxValue = arr[idx];
					}
				} else if (e == N + 1) {  // case 2: max counter operation
					floorValue = currentMaxValue;
				}
				//  System.out.printf("%s: %s, [floorValue = %s], [currentMaxValue = %s]\n", e, Arrays.toString(arr), floorValue, currentMaxValue);
			}

			// *lazy update of max counter for all elements
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < floorValue) {
					arr[i] = floorValue;
				}
			}

			return arr;
		}

	}

}
