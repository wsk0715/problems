package com.leetcode.solved.easy;

import java.util.HashMap;
import java.util.Map;

public class _Solution_205 {

	// 205. Isomorphic Strings - Easy
	// https://leetcode.com/problems/isomorphic-strings
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "egg";
		String t = "add";
		System.out.println(sol.isIsomorphic(s, t));
		// #case 2
		String s2 = "badc";
		String t2 = "baba";
		System.out.println(sol.isIsomorphic(s2, t2));

	}

	static class Solution {

		public boolean isIsomorphic(String s, String t) {
			// 1. 주어진 문자열 s, t가 isomorphic 한지 판별하라.
			// 1-1. s의 각 문자를 교체하여 t가 될 수 있다면 두 문자열은 isomorphic 하다.
			// 1-2. egg <-> add의 경우, e -> a, g -> d
			// 2. s의 길이는 1 이상, 5 * 10^4 이하이다.
			// 2-1. s와 t의 길이는 같다.


			Map<Character, Character> hmST = new HashMap<>();
			Map<Character, Character> hmTS = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char cs = s.charAt(i);
				char ct = t.charAt(i);

				// a. cs -> ct 맵핑이 이미 되어있는지 확인
				if (hmST.containsKey(cs)) {
					if (hmST.get(cs) != ct) {
						return false;
					}
				}

				// b. ct -> cs 맵핑여부 확인
				if (hmTS.containsKey(ct)) {
					if (hmTS.get(ct) != cs) {
						return false;
					}
				}

				hmST.put(cs, ct);
				hmTS.put(ct, cs);
			}

			return true;
		}

	}

}
