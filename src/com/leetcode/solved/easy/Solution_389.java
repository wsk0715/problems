package com.leetcode.solved.easy;

public class Solution_389 {

	// 389. Find the Difference - Easy
	// https://leetcode.com/problems/find-the-difference
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "abcd";
		String t = "abcde";
		System.out.println(sol.findTheDifference(s, t));
		// #case 2
		String s2 = "";
		String t2 = "y";
		System.out.println(sol.findTheDifference(s2, t2));
	}

	static class Solution {

		public char findTheDifference(String s, String t) {
			// 1. 문자열 s, t가 주어진다.
			// 1-1. t는 s의 문자들을 뒤섞고, 무작위 문자 하나를 더하여 만들어진다.
			// 2. t에 추가된 문자를 반환하라.

			// 0 <= s.length <= 1000
			// t.length == s.length + 1
			// s, t는 알파벳 소문자만로만 이루어져있다.


			int[] counts = new int[26];
			for (char c : s.toCharArray()) {
				counts[c - 'a'] += 1;
			}
			for (char c : t.toCharArray()) {
				counts[c - 'a'] -= 1;
			}

			for (int i = 0; i < counts.length; i++) {
				if (counts[i] != 0) {
					return (char) ('a' + i);
				}
			}

			return 0;
		}

	}

}
