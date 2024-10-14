package com.leetcode.solved.easy;

import java.util.Stack;

public class Solution_20 {

	// 20. Valid Parentheses - Easy
	// https://leetcode.com/problems/valid-parentheses
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "()";
		System.out.println(sol.isValid(s));
		// #case 2
		String s2 = "()[]{}";
		System.out.println(sol.isValid(s2));
		// #case 3
		String s3 = "(]";
		System.out.println(sol.isValid(s3));
		// #case 4
		String s4 = "([])";
		System.out.println(sol.isValid(s4));
	}

	static class Solution {

		public boolean isValid(String s) {
			// 1. 문자열 s의 모든 문자가 완벽하게 짝지어져있는 경우 true, 아니라면 false를 반환한다.
			// 2. 입력으로 문자열 s가 주어진다.
			// 2-1. s의 길이는 1 이상, 10^4 이하이다.
			// 2-2. s는 (, ), [, ], {, } 6개의 문자로만 이루어져있다.

			Stack<Character> stack = new Stack<>();
			for (char c : s.toCharArray()) {
				switch (c) {
					case '(':
					case '[':
					case '{':
						stack.push(c);
						break;
					case ')':
						if (!stack.isEmpty() && stack.peek() == '(') {
							stack.pop();
							break;
						} else {
							return false;
						}
					case ']':
						if (!stack.isEmpty() && stack.peek() == '[') {
							stack.pop();
							break;
						} else {
							return false;
						}
					case '}':
						if (!stack.isEmpty() && stack.peek() == '{') {
							stack.pop();
							break;
						} else {
							return false;
						}
				}
			}

			return stack.isEmpty();
		}

	}

}
