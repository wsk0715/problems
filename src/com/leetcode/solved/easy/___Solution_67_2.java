package com.leetcode.solved.easy;

public class ___Solution_67_2 {

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

			// 문자열을 이용한 풀이
			StringBuilder sb = new StringBuilder();
			int i = a.length() - 1;
			int j = b.length() - 1;

			int carry = 0;
			while (i >= 0 || j >= 0 || carry == 1) {
				if (i >= 0) {
					carry += a.charAt(i--) - '0';
				}
				if (j >= 0) {
					carry += b.charAt(j--) - '0';
				}
				sb.append(carry % 2);
				carry = carry / 2;
			}

			return sb.reverse().toString();
		}

	}

}
