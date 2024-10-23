package com.leetcode.solved.medium;

public class _Solution_198_2 {

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

			// House Robber 다른 풀이
			// 반복문을 돌려서 이전까지의 최댓값을 찾는 방식으로 풀었는데, 이 부분도 점화식으로 해결이 가능하다.
			// 큰 틀인 점화식은 동일하다.
			// dp[n] = max(dp[1], ..., dp[n-2])
			// 반복문 내부에서 최댓값을 구하는 코드는 아래와 같이 대체가 가능하다.
			// Math.max(dp[i-1], dp[i-2] + nums[i])
			// 현재 위치한 털지 않았을 때(dp[i-2])와 털었을 때(dp[i-2] + nums[i])의 액수만을 비교하는 방법이다.

			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			if (nums.length == 1) {
				return dp[0];
			}

			dp[1] = Math.max(nums[0], nums[1]);

			for (int i = 2; i < dp.length; i++) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);  // 현재 집을 털지 않았을 때, 털었을 때의 금액을 비교한다.
			}

			return dp[dp.length - 1];
		}

	}

}
