package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181838 {
	// 날짜 비교하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181838
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] date1, int[] date2) {
			// 연도 비교
			if (date1[0] < date2[0]) {
				return 1;
			} else if (date1[0] > date2[0]) {
				return 0;
			}

			// 월 비교
			if (date1[1] < date2[1]) {
				return 1;
			} else if (date1[1] > date2[1]) {
				return 0;
			}

			// 일 비교
			if (date1[2] < date2[2]) {
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
