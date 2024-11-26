package com.leetcode.solved.easy;

public class _Solution_278 {

	// 278. First Bad Version - Easy
	// https://leetcode.com/problems/first-bad-version
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int n = 4;
		System.out.println(sol.firstBadVersion(n));
	}

	static class Solution {

		public int firstBadVersion(int n) {
			// 1. 실패한 버전(bad version) 이후의 버전은 모두 실패한 버전이다.
			// 2. 주어진 API(isBadVersion)를 활용하여 최초의 실패한 버전을 찾아라.


			int left = 1;
			int right = n;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (isBadVersion(mid)) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			return left;
		}

		// The isBadVersion API is defined in the parent class VersionControl.
		boolean isBadVersion(int version) {
			// dummy method, implemented by leetcode
			return false;
		}

	}

}
