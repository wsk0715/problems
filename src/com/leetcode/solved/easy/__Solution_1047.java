package com.leetcode.solved.easy;

public class __Solution_1047 {

	// 1047. Remove All Adjacent Duplicates In String - Easy
	// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "abbaca";
		System.out.println(sol.removeDuplicates(s));
	}

	static class Solution {

		public String removeDuplicates(String s) {
			// 1. 알파벳 소문자로만 이루어진 문자열 s가 주어진다.
			// 2. 문자열 s에서 서로 인접하며, 중복되는 두 문자를 모두 찾아 제거하여 반환하라.
			// 3. s의 길이는 1 이상, 10^5 이하이다.


			StringBuilder stack = new StringBuilder();
			for (char c : s.toCharArray()) {
				int l = stack.length();

				if (l > 0 && stack.charAt(l - 1) == c) {
					stack.deleteCharAt(l - 1);
				} else {
					stack.append(c);
				}
			}

			return stack.toString();
		}

	}

}
