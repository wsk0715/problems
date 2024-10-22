package com.leetcode.solved.easy;

public class Solution_70 {

	// 70. Climbing Stairs - Easy
	// https://leetcode.com/problems/climbing-stairs
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int n = 2;
		System.out.println(sol.climbStairs(n));
		// #case 2
		int n2 = 3;
		System.out.println(sol.climbStairs(n2));
		// #case 3
		int n3 = 4;
		System.out.println(sol.climbStairs(n3));
		// #case 4
		int n4 = 5;
		System.out.println(sol.climbStairs(n4));
	}

	static class Solution {

		public int climbStairs(int n) {
			// 1. 정수 n이 주어진다.
			// 1-1. n은 계단을 올라 도달해야하는 높이이다.
			// 2. 계단은 한 번에 1칸, 또는 2칸 오를 수 있다.
			// 3. 계단을 올라 정상에 오를 수 있는 조합의 경우의 수를 반환하라.
			// 4. n의 범위는 1 이상, 45 이하이다.

			// a. 점화식 설정
			// 한 번에 계단을 1 또는 2칸 오를 수 있다.
			// -> 정상(n)에 오를 수 있는 방법 = n-1칸까지 오는 방법 + n-2칸까지 오는 방법
			// dp[n] = dp[n-1] + dp[n-2], (n > 2)

			// b. 결과 배열 생성, 초기 값 할당
			int[] dp = new int[n + 1];
			if (n >= 1) {
				dp[1] = 1;
			}
			if (n >= 2) {
				dp[2] = 2;
			}

			// c. i = 2부터 점화식 실행
			for (int i = 3; i < dp.length; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}

			return dp[n];
		}

	}

}
