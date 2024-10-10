package com.leetcode.solved.easy;

public class _Solution_121 {

	// 121. Best Time to Buy and Sell Stock - Easy
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(sol.maxProfit(prices));
		// #case 2
		int[] prices2 = {7, 6, 4, 3, 1};
		System.out.println(sol.maxProfit(prices2));
	}

	static class Solution {

		public int maxProfit(int[] prices) {
			// 1. prices[i]는 i번째 날의 상품의 가격이다.
			// 2. 특정 일자에 상품을 구입하여 다른 날 판매할 수 있다.
			// 3. 이 때 발생할 수 있는 최대 이익을 반환한다.
			// 3-1. 이익을 낼 수 없다면 0을 반환한다.

			int buyPrice = Integer.MAX_VALUE;
			int maxProfit = 0;
			for (int price : prices) {
				if (price < buyPrice) {  // a. 기존 구매하려던 가격보다 낮은 가격을 찾으면
					buyPrice = price;  // a-1. 해당 가격에 새로 구입
				}

				int newProfit = price - buyPrice;  // b. 기존에 구입한 상품을 현재 판매한다면 얻게 되는 이익
				if (maxProfit < newProfit) {  // b-1. 새로운 이익이 기존 이익보다 크다면
					maxProfit = newProfit;  // b-2. 해당 이익을 취함
				}
			}

			return maxProfit;
		}

	}

}
