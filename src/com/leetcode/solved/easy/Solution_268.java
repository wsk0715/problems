package com.leetcode.solved.easy;

public class Solution_268 {

	// 268. Missing Number - Easy
	// https://leetcode.com/problems/missing-number
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {3, 0, 1};
		System.out.println(sol.missingNumber(nums));
		// #case 2
		int[] nums2 = {0, 1};
		System.out.println(sol.missingNumber(nums2));
		// #case 3
		int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		System.out.println(sol.missingNumber(nums3));
	}

	static class Solution {

		public int missingNumber(int[] nums) {
			// 1. 0부터 n까지의 수를 담은 배열 nums가 주어진다.
			// 2. 주어진 범위에서 누락된 유일한 수를 반환하라.
			// 3. n은 배열 nums의 길이(nums.length)와 같다.
			// 3-1. n의 범위는 1 이상, 10^4 이하이다.
			// 3-2. nums[i]의 범위는 0 이상, n 이하이다.
			// 3-3. nums의 모든 원소는 고유한 값을 갖는다.

			// a. 1부터 n까지의 수의 합은? -> n * (n+1) / 2
			int sum = nums.length * (nums.length + 1) / 2;

			// b. nums의 모든 원소의 합을 구한다.
			int result = 0;
			for (int num : nums) {
				result += num;
			}

			// c. a에서 b를 뺀 값이 주어진 범위에서 빠진 수이다.
			return sum - result;
		}

	}

}
