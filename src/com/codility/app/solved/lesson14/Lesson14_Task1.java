package com.codility.app.solved.lesson14;

public class Lesson14_Task1 {

	// Lesson 14 - Binary search algorithm: MinMaxDivision
	// https://app.codility.com/programmers/lessons/14-binary_search_algorithm/
	public static void main(String[] args) {
		Solution sol = new Solution();

		int K = 3;
		int M = 5;
		int[] A = {2, 1, 5, 1, 2, 2, 2};
		int result = sol.solution(K, M, A);
		System.out.printf("result A: %s\n", result);
	}

	static class Solution {

		public int solution(int K, int M, int[] A) {
			// K: number of blocks
			// M: maximum value of any element in array A
			// A: non-empty integer array of size N
			// minimize the largest sum.

			// a. find maximum value and total sum of array A
			int max = 0;
			long sum = 0;
			for (int n : A) {
				if (n > max) {
					max = n;
				}
				sum += n;
			}

			// b. set left and right boundary of binary search
			int left = max;  // minimum value at least block should have
			long right = sum;  // maximum value when contains all elements in one block
			long result = sum;  // initial result is total sum

			// c. compute result using binary search
			while (left <= right) {
				long mid = (left + right) / 2;

				// check if can divide blocks with current mid value using greedy algorithm
				int blocks = 1;  // minimum blocks count
				long currentSum = 0;
				for (int n : A) {
					// check if current sum exceeds mid value
					if (currentSum + n > mid) {
						// end current block and start new block
						blocks += 1;
						currentSum = n;
					} else {  // not exceeds
						// add element to current block
						currentSum += n;
					}
				}

				// check if block count not exceeds K, and reduce right boundary
				if (blocks <= K) {
					result = mid;
					right = mid - 1;
				} else {  // if exceeds
					left = (int) (mid + 1);
				}
			}
			
			return (int) result;
		}

	}

}
