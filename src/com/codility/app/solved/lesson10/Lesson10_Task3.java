package com.codility.app.solved.lesson10;

import java.util.ArrayList;

public class Lesson10_Task3 {

	// Lesson 10 - Prime and composite numbers: Flags
	// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
		int result = sol.solution(A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int[] A) {
			int N = A.length;

			// a. find all the peaks
			ArrayList<Integer> peaks = new ArrayList<>();

			for (int i = 1; i < N - 1; i++) {
				if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
					peaks.add(i);
				}
			}

			// check peaks is empty
			if (peaks.isEmpty()) {
				return 0;
			}

			// b. place flags using binary search
			int left = 1;
			int right = peaks.size();
			int maxFlags = 0;

			while (left <= right) {
				int mid = (left + right) / 2;  // number of flags to search
				int usedFlags = 1;
				int lastPosition = peaks.get(0);

				for (int i = 1; i < peaks.size(); i++) {
					if (peaks.get(i) - lastPosition >= mid) {
						usedFlags++;
						lastPosition = peaks.get(i);
						if (usedFlags == mid) {
							break;
						}
					}
				}

				if (usedFlags >= mid) {
					maxFlags = mid;
					left = mid + 1; // try more flags
				} else {
					right = mid - 1; // try fewer flags
				}
			}

			return maxFlags;
		}

	}

}
