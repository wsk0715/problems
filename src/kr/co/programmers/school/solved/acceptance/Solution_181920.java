package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181920 {
	// 카운트 업
	// https://school.programmers.co.kr/learn/courses/30/lessons/181920
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int start_num, int end_num) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = start_num; i <= end_num; i++) {
				al.add(i);
			}
			return toArray(al);
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
