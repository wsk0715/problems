package com.leetcode.solved.medium;

import java.util.Arrays;

public class __Solution_322 {

	// 322. Coin Change - Medium
	// https://leetcode.com/problems/coin-change
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(sol.coinChange(coins, amount));
		// #case 2
		int[] coins2 = {2};
		int amount2 = 3;
		System.out.println(sol.coinChange(coins2, amount2));
		// #case 3
		int[] coins3 = {1};
		int amount3 = 0;
		System.out.println(sol.coinChange(coins3, amount3));
	}

	static class Solution {

		public int coinChange(int[] coins, int amount) {
			// 1. 정수로 이루어진 배열 coins와, 정수 amount가 주어진다.
			// 1-1. coins 배열은 서로 다른 동전의 액면가(denominations)를 나타낸다.
			// 1-2. amount는 목표 액수를 나타낸다.
			// 2. 목표 액수와 정확히 일치시킬 수 있는 최소한의 동전의 갯수를 반환하라.
			// 2-1. 주어진 동전들로 달성할 수 없다면 -1을 반환하라.
			// 2-2. 각 동전의 갯수는 무한하다고 가정한다.
			// 3. coins의 길이는 1 이상, 12 이하이다.
			// 3-1. coins[i](동전의 단위)의 범위는 1 이상, 2^31-1 이하이다.
			// 3-2. amount의 범위는 0 이상, 10^4 이하이다.

			// 동전 오름차순 정렬
			Arrays.sort(coins);

			// 동전 문제 -> 그리디 but, 큰 단위가 작은 단위를 대체할 수 없다. -> dp
			// 1부터 amount까지, 보유한 동전으로 만들 수 있는지 확인한다.

			int[] dp = new int[amount + 1];  // 각 금액 별 필요한 최소 동전의 갯수 배열
			Arrays.fill(dp, amount + 1);  // 불가능한 갯수로 채우기, 모든 동전을 1로 채워도 amount + 1보다는 작다.
			dp[0] = 0;  // 0을 만드는 데 필요한 동전 갯수는 0이다.

			for (int i = 1; i <= amount; i++) {  // 현재 금액에 대해,
				for (int coin : coins) {  // 각각의 동전을 사용하여,
					if (i - coin >= 0) {  // 현재 동전을 사용할 수 있다면,
						dp[i] = Math.min(dp[i], dp[i - coin] + 1);  // 필요한 동전의 갯수를 업데이트
					}
				}
			}

			return dp[amount] > amount ? -1 : dp[amount];
		}

	}

}
