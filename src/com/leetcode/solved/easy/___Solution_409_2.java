package com.leetcode.solved.easy;

public class ___Solution_409_2 {

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


			// 각 문자의 등장 횟수 카운트
			int[] chars = new int[128];
			for (char c : s.toCharArray()) {
				chars[c]++;
			}

			// 결과 계산
			int result = 0;
			for (int count : chars) {
				result += (count / 2) * 2;  // a. 현재 문자가 짝수 번 등장하는 경우

				// b. 홀수 번 등장하는 경우
				if (result % 2 == 0 && count % 2 == 1) {
					result += 1;
				}
			}

			return result;
		}

	}

}
