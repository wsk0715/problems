package com.leetcode.solved.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_125 {

	// 125. Valid Palindrome - Easy
	// https://leetcode.com/problems/valid-palindrome
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "A man, a plan, a canal: Panama";
		System.out.println(sol.isPalindrome(s));
		// #case 2
		String s2 = "race a car";
		System.out.println(sol.isPalindrome(s2));
		// #case 3
		String s3 = " ";
		System.out.println(sol.isPalindrome(s3));
	}

	static class Solution {

		public boolean isPalindrome(String s) {
			// 1. 문자열 s에 대해, 모든 문자를 소문자로 바꾼 후, 알파벳, 숫자가 아닌 문자를 모두 제거한 후, 거꾸로 읽어도 동일한 형태를 띠면 Palindrome 문자열이라고 한다.
			// 2. 문자열 s가 주어진다. s가 Palindrome인지 판별하라.
			// 3. s의 길이는 1 이상, 2 * 10^5 이하이다.
			// 3-1. s는 ASCII 문자로만 이루어져있다.

			// a. 정규 표현식을 이용해 알파벳, 숫자를 제외한 문자 제거 후, 대문자를 소문자로 변환
			s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

			// b. 원본 문자열을 순회하며 스택, 큐에 각각 집어넣는다.
			Stack<Character> stack = new Stack<>();
			Queue<Character> queue = new LinkedList<>();
			for (Character c : s.toCharArray()) {
				stack.push(c);
				queue.add(c);
			}

			// c. 큐와 스택에서 문자를 각각 꺼내며 비교한다.
			int l = stack.size();
			for (int i = 0; i < l; i++) {
				if (stack.pop() != queue.remove()) {  // 하나의 문자라도 다른 경우
					return false;
				}
			}

			return true;  // 모든 문자가 같은 경우
		}

	}

}
