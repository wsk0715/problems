package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181864 {
	// 문자열 바꿔서 찾기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181864
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String s, String pat) {
			pat = pat.replaceAll("A", "T")
					 .replaceAll("B", "A")
					 .replaceAll("T", "B");
			return s.contains(pat) ? 1 : 0;
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


