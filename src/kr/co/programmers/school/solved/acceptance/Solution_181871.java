package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181871 {
	// 문자열이 몇 번 등장하는지 세기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181871
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String s, String pat) {
			int r = 0;
			int l = pat.length();
			for (int i = 0; i < s.length() - l + 1; i++) {
				if (s.substring(i, i + l)
					 .equals(pat)) {
					r += 1;
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
