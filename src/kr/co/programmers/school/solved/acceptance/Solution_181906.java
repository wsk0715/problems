package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181906 {
	// 접두사인지 확인하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181906
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String s, String p) {
			if (s.startsWith(p)) {
				return 1;
			}
			return 0;
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
