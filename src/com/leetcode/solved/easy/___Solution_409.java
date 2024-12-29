package com.leetcode.solved.easy;

import java.util.HashMap;

public class ___Solution_409 {

	// 409. Longest Palindrome - Easy
	// https://leetcode.com/problems/longest-palindrome
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "abccccdd";
		System.out.println(sol.longestPalindrome(s));
	}

	static class Solution {

		public int longestPalindrome(String s) {
			// 1. 문자열 s를 재배열해서 만들 수 있는 가장 긴 팰린드롬(palindrome)의 길이를 반환하라.
			// 1-1. palindrome이란 앞뒤를 뒤집어도 똑같이 읽히는 문자열이다.

			// 1 <= s.length <= 2000
			// s는 알파벳 소문자, 대문자로 이루어져있다.


			HashMap<Character, Integer> charCount = new HashMap<>();
			for (char c : s.toCharArray()) {
				charCount.put(c, charCount.getOrDefault(c, 0) + 1);
			}

			int length = 0;
			boolean oddFound = false;

			for (int count : charCount.values()) {
				if (count % 2 == 0) {
					length += count; // 짝수일 때, 그대로 더함
				} else {
					length += count - 1; // 홀수일 때, 하나 빼고 더함
					oddFound = true;
				}
			}

			// 홀수 처리
			if (oddFound) {
				length += 1;
			}

			return length;
		}

	}

}
