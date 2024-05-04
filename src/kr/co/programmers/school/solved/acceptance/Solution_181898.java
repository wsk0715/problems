package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181898 {
	// 가까운 1 찾기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181898
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr, int idx) {
			for (int i = idx; i < arr.length; i++) {
				if (arr[i] == 1) {
					return i;
				}
			}
			return -1;
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
