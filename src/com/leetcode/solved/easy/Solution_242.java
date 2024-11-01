package com.leetcode.solved.easy;

public class Solution_242 {

	// 242. Valid Anagram - Easy
	// https://leetcode.com/problems/valid-anagram
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "anagram";
		String t = "nagaram";
		System.out.println(sol.isAnagram(s, t));
		// #case 2
		String s2 = "rat";
		String t2 = "car";
		System.out.println(sol.isAnagram(s2, t2));
	}

	static class Solution {

		public boolean isAnagram(String s, String t) {
			// 1. 두 문자열 s, t가 주어진다. t가 s의 애너그램인지 판별하라.
			// 1-1. 애너그램(anagram): 문자열 t의 문자들을 재조합해서 문자열 s를 만들 수 있으면 t를 s의 애너그램이라고 한다.
			// 2. s, t의 길이는 1 이상, 5 * 10^4 이하이다.
			// 2-1. s, t는 영문 소문자로만 이루어져있다.

			// 각 문자가 몇 번씩 들어가는지만 판별하면 된다.

			// 예외 처리; 두 문자열의 길이가 다를 때
			if (s.length() != t.length()) {
				return false;
			}

			// a. 문자의 갯수를 담을 배열 생성
			int[] letters = new int[26];

			// b. s,t를 순회하며 문자의 갯수를 기록한다.
			int l = s.length();
			for (int i = 0; i < l; i++) {
				letters[s.charAt(i) - 'a'] += 1;  // s의 문자에 해당하는 인덱스 값 증가
				letters[t.charAt(i) - 'a'] -= 1;  // t의 문자에 해당하는 인덱스 값 감소
			}

			// c. 결과 계산
			for (int n : letters) {
				if (n != 0) {
					return false;
				}
			}

			return true;
		}

	}

}
