package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181833 {
	// 특별한 이차원 배열 1
	// https://school.programmers.co.kr/learn/courses/30/lessons/181833
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[][] solution(int n) {
			int[][] r = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						r[i][j] = 1;
					}
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
