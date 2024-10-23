package com.leetcode.solved.medium;

import java.util.Arrays;

public class _Solution_198 {

	// 198. House Robber - Medium
	// https://leetcode.com/problems/house-robber
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] nums = {1, 2, 3, 1};
		System.out.println(sol.rob(nums));
		// #case 2
		int[] nums2 = {2, 7, 9, 3, 1};
		System.out.println(sol.rob(nums2));
		// #case 3
		int[] nums3 = {1, 2};
		System.out.println(sol.rob(nums3));
	}

	static class Solution {

		public int rob(int[] nums) {
			// 1. 당신은 강도이며, 길을 따라 늘어선 집들을 털려고 한다.
			// 1-1. 각각의 집은 일정 금액의 돈을 가지고 있다.
			// 1-2. 도둑질의 유일한 제약조건은 인접한 집을 같은 날 털게 되면 경찰에 연락이 가게 되어있다.
			// 2. 정수 배열 nums는 각각의 집이 보유한 액수를 나타내는 배열이다.
			// 3. 오늘 하룻동안 경찰에게 들키지 않고 털 수 있는 최대 금액을 반환하는 함수를 작성하라.
			// 4. nums의 길이는 1 이상, 100 이하이다.
			// 4-1. nums[i]의 범위는 0 이상, 400 이하이다.

			// a. 각각의 집을 나타내는 배열을 만들어, 각각의 집에 도달했을 때 확보할 수 있는 최대 금액을 담는다.
			// a-1. n번째 집에 도착했을 때의 최대 금액은, 첫 번째 집에서부터 n-2번째 집까지의 금액 중 가장 큰 값 + n번째 집의 보유금액이다.
			// dp[n] = max(dp[1], ..., dp[n-2])
			int[] dp = new int[nums.length];
			dp[0] = nums[0];  // 첫 번째 집
			if (nums.length == 1) {  // 집이 하나 뿐일때의 예외처리
				return dp[0];
			}

			dp[1] = Math.max(nums[0], nums[1]);  // 두 번째 집의 최대값

			// b. 점화식 계산 (n >= 3)
			for (int i = 2; i < dp.length; i++) {
				int max = -1;
				for (int j = 0; j <= i - 2; j++) {  // b-1. 0부터 i-2까지의 집 중 가장 큰 값을 찾는다.
					if (dp[j] >= max) {
						max = dp[j];
					}
				}
				dp[i] = max + nums[i];  // b-2. 현재 집을 턴 금액을 더한다.
			}

			// c. 오름차순 정렬
			Arrays.sort(dp);

			// d. 가장 큰 값 반환
			return dp[dp.length - 1];
		}

	}

}
