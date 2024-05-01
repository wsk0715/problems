package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;

public class _Solution_12918 {
	// 문자열 다루기 기본 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12918
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public boolean solution(String s) {
			int l = s.length();
			if (l != 4 && l != 6) {
				return false;
			}
			try {
				Integer.parseInt(s);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
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
