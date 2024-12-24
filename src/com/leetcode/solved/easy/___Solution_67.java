package com.leetcode.solved.easy;

import java.math.BigInteger;

public class ___Solution_67 {

	// 67. Add Binary - Easy
	// https://leetcode.com/problems/add-binary
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String a = "11";
		String b = "1";
		System.out.println(sol.addBinary(a, b));
		// #case 2
		String a2 = "1010";
		String b2 = "1011";
		System.out.println(sol.addBinary(a2, b2));
	}

	static class Solution {

		public String addBinary(String a, String b) {
			// 1. 이진수로 표현된 문자열 a, b가 주어졌을 때, 두 문자열의 합을 이진수로 반환하라.

			// 1 <= a.length, b.length <= 10^4

			BigInteger sum = new BigInteger(a, 2).add(new BigInteger(b, 2));

			return sum.toString(2);
		}

	}

}
