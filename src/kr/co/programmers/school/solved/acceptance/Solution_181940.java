package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181940 {
	// 문자열 곱하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181940
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s, int k) {
			return repeat(s, k);
		}

		public static String repeat(String str, int count) {
			if (count <= 0) return "";
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count; i++) {
				sb.append(str);
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
