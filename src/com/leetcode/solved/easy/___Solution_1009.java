package com.leetcode.solved.easy;

public class ___Solution_1009 {

	// Complement of Base 10 Integer - Easy
	// https://leetcode.com/problems/complement-of-base-10-integer
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int n = 5;
		System.out.println(sol.bitwiseComplement(n));
	}

	static class Solution {

		public int bitwiseComplement(int n) {
			// 1. complement of integer란 어떤 정수를 이진수 형태로 변환 후, 모든 0과 1을 서로 바꾼 값이다.
			// 1-1. 예를 들어, 5(101) -> 2(010)
			// 2. n이 주어졌을 때, 이를 complement 한 값을 구하라.

			// 0 <= n <= 10^9


			int MASK = (1 << Integer.toBinaryString(n).length()) - 1;  // n과 동일한 길이를 갖고, 모든 비트가 1인 마스크

			return MASK ^ n;  // 마스크와 XOR 연산
		}

	}

}
