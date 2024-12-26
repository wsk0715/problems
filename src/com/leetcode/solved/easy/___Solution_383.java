package com.leetcode.solved.easy;

public class ___Solution_383 {

	// 383. Ransom Note - Easy
	// https://leetcode.com/problems/ransom-note
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String ransomNote = "a";
		String magazine = "b";
		System.out.println(sol.canConstruct(ransomNote, magazine));
	}

	static class Solution {

		public boolean canConstruct(String ransomNote, String magazine) {
			// 1. magazine의 문자를 이용해 문자열 ransomNote를 만들 수 있다면 true를 반환하라.

			// 1 <= ransomNote.length, magazine.length <= 10^5
			// ransomeNote와 magazine은 알파벳 소문자로만 이루어져있다.


			int[] letters = new int[26];
			for (char c : ransomNote.toCharArray()) {
				letters[c - 'a'] += 1;
			}

			for (char c : magazine.toCharArray()) {
				letters[c - 'a'] -= 1;
			}

			for (int letter : letters) {
				if (letter > 0) {
					return false;
				}
			}

			return true;
		}

	}

}
