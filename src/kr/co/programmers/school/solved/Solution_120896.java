package kr.co.programmers.school.solved;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_120896 {
	// 한 번만 등장한 문자
	// https://school.programmers.co.kr/learn/courses/30/lessons/120896
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "hello";
		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			int[] counts = new int[26];
			ArrayList<String> arr = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				counts[s.charAt(i) - 97]++;
			}

			for (int i = 0; i < counts.length; i++) {
				if (counts[i] == 1) {
					arr.add(String.valueOf(((char) (i + 97))));
				}
			}
			Collections.sort(arr);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.size(); i++) {
				sb.append(arr.get(i));
			}
			return sb.toString();
		}

	}

}
