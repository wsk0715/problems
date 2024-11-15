package com.leetcode.solved.easy;

public class _Solution_746 {

	// 746. Min Cost Climbing Stairs - Easy
	// https://leetcode.com/problems/min-cost-climbing-stairs
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] cost = {10, 15, 20};
		System.out.println(sol.minCostClimbingStairs(cost));
	}

	static class Solution {

		public int minCostClimbingStairs(int[] cost) {
			// 1. cost[i]는 i번째 계단에서의 비용이다.
			// 1-1. 비용을 지불한 후 한 칸 또는 두 칸을 오를 수 있다.
			// 2. 인덱스 0에서 시작할 수도 있고, 1에서 시작할 수도 있다.
			// 3. 계단을 끝까지 오르기 위한 최소 비용을 반환하라.
			// 4. cost의 길이는 2 이상, 1000 이하이다.
			// 4-1. cost[i]는 0 이상, 999 이하이다.


			int N = cost.length;

			int[] dp = new int[N + 1];

			for (int i = 2; i <= N; i++) {
				dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
			}


			return dp[N];
		}

	}

}
