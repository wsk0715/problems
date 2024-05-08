package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Arrays;

public class _Solution_181855 {
	// 문자열 묶기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181855
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String[] strArr) {
			int[] r = new int[30];
			for (int i = 0; i < strArr.length; i++) {
				int idx = strArr[i].length();
				r[idx - 1] += 1;
			}
			Arrays.sort(r);
			return r[r.length - 1];
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
