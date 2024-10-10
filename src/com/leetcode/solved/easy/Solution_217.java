package com.leetcode.solved.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution_217 {

	// 217. Contains Duplicate - Easy
	// https://leetcode.com/problems/contains-duplicate
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {2, 14, 18, 22, 22};
		System.out.println(sol.containsDuplicate(nums));
	}

	static class Solution {

		public boolean containsDuplicate(int[] nums) {
			// 1. 중복되는 원소가 있다면, true 반환
			// 1-1. 없다면 false 반환

			// a. 중복? -> 집합(set)
			Set<Integer> hs = new HashSet<>();
			for (int num : nums) {
				if (!hs.isEmpty() && hs.contains(num)) {
					return true;
				}

				hs.add(num);
			}

			return false;
		}

	}

}
