package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181902 {
	// 문자 개수 세기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181902
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "Programmers";
		sol.solution(input);
	}

	static class Solution {
		public int[] solution(String s) {
			int[] r = new int[52];

			for (int i = 0; i < s.length(); i++) {
				int c = s.charAt(i);
				// 대문자인 경우
				if (65 <= c && c <= 90) {
					c -= 65;
					r[c] += 1;
					continue;
				}
				// 소문자인 경우
				if (97 <= c && c <= 122) {
					c -= 97;
					r[c + 26] += 1;
				}
			}

			return r;
		}

		// Libraries
		private int[] toArray(ArrayList<Integer> al) {
			// ArrayList<Integer> to int[]
			int[] arr = new int[al.size()];
			for (int i = 0; i < al.size(); i++) {
				arr[i] = al.get(i);
			}
			return arr;
		}

	}

}
