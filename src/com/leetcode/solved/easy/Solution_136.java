package com.leetcode.solved.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution_136 {

	// 136. Single Number - Easy
	// https://leetcode.com/problems/single-number
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {2, 2, 1};
		System.out.println(sol.singleNumber(nums));
	}

	static class Solution {

		public int singleNumber(int[] nums) {
			// 1. nums는 하나의 원소를 제외한 나머지 원소들이 두 번씩 나타나는 정수 배열이다.
			// 1-1. 두 번 나타나지 않은 하나의 원소를 찾아내 반환하라.
			// 2. nums의 길이는 1 이상, 3 * 10^4 이하이다.
			// 2-1. nums[i]는 -3 * 10^4 이상, 3 * 10^4 이하이다.


			Set<Integer> hs = new HashSet<>();
			for (int num : nums) {
				if (hs.contains(num)) {
					hs.remove(num);
				} else {
					hs.add(num);
				}
			}

			return hs.iterator().next();
		}

	}

}
