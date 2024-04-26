package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181899 {
	// 카운트 다운
	// https://school.programmers.co.kr/learn/courses/30/lessons/181899
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int start, int end_num) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = start; i >= end_num; i--) {
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
