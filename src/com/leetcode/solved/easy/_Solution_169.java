package com.leetcode.solved.easy;

import java.util.Arrays;

public class _Solution_169 {

	// 169. Majority Element - Easy
	// https://leetcode.com/problems/majority-element
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {3, 2, 3};
		System.out.println(sol.majorityElement(nums));
		// #case 2
		int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
		System.out.println(sol.majorityElement(nums2));
	}

	static class Solution {

		public int majorityElement(int[] nums) {
			// 1. 정수 배열 nums에서 majority element를 반환하라.
			// 1-1. majority element란 nums의 길이가 n일 때, n/2회 이상 나타나는 원소이다.

			// n == nums.length
			// 1 <= n <= 5 * 10^4
			// -10^9 <= nums[i] <= 10^9


			if (nums.length == 1) {
				return nums[0];
			}

			int n = nums.length;
			Arrays.sort(nums);

			int before = -1;
			int count = 1;
			for (int i : nums) {
				if (before != i) {
					count = 1;
				} else {
					count += 1;

					if (count > n / 2) {
						return i;
					}
				}
				before = i;

			}

			return 0;
		}

	}

}
