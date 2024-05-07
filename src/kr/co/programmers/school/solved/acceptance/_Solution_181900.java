package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181900 {
	// 글자 지우기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181900
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s, int[] indices) {
			StringBuilder sb = new StringBuilder(s);

			for (int idx : indices) {
				sb.replace(idx, idx + 1, " ");
			}

			return sb.toString()
					 .replaceAll(" ", "");
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
