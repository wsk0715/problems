package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181904 {
	// 세로 읽기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181904
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s, int m, int c) {
			StringBuilder sb = new StringBuilder();
			for (int i = c - 1; i < s.length(); i += m) {
				sb.append(s.charAt(i));
			}
			return sb.toString();
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
