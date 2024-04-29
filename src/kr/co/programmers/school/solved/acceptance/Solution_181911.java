package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181911 {
	// 부분 문자열 이어 붙여 문자열 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181911
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String[] s, int[][] parts) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length; i++) {
				sb.append((s[i].substring(parts[i][0], parts[i][1] + 1)));
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
