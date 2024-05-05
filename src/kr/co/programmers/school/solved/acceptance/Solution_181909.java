package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_181909 {
	// 접미사 배열
	// https://school.programmers.co.kr/learn/courses/30/lessons/181909
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "banana";
		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String s) {
			String[] r = new String[s.length()];
			for (int i = r.length - 1; i >= 0; i--) {
				r[i] = s.substring(i);
			}
			Arrays.sort(r);
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
