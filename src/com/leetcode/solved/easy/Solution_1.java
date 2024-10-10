package com.leetcode.solved.easy;

import java.util.Arrays;

public class Solution_1 {

	// 1. Two Sum - Easy
	// https://leetcode.com/problems/two-sum
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(sol.twoSum(nums, target)));
	}

	static class Solution {

		public int[] twoSum(int[] nums, int target) {
			// 1. 주어진 배열 nums에서 두 수를 뽑아 target이 되는 조합의 index를 반환한다.
			// 2. 중복은 허용하지 않는다.
			// 3. 조건을 만족하는 수의 쌍은 항상 하나만 존재한다.

			for (int i = 0; i < nums.length; i++) {
				for (int j = 1; j < nums.length; j++) {
					if (i == j) {
						break;  // 중복 제외
					}

					if (nums[i] + nums[j] == target) {
						return new int[]{i, j};
					}
				}
			}

			return null;
		}

	}

}
