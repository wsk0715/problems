package com.leetcode.solved.easy;

public class Solution_125_2 {

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

			// Valid Palindrome 다른 풀이
			// 큐와 스택을 이용하는 문자열의 길이에 따라 많은 양의 메모리를 필요로 할 수 있다.
			// 포인터를 이용하여 문자열의 앞, 뒤에서 탐색하는 풀이

			// a. 정규 표현식을 이용해 알파벳, 숫자를 제외한 문자 제거 후, 대문자를 소문자로 변환
			s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

			// b. 포인터 설정
			int left = 0;
			int right = s.length() - 1;

			// c. 탐색
			while (left < right) {
				if (s.charAt(left) != s.charAt(right)) {
					return false;
				}

				left += 1;
				right -= 1;
			}

			return true;  // 모든 문자가 같은 경우
		}

	}

}
