package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;

public class Solution_12950 {
	// 행렬의 덧셈 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12950
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int l = arr1.length;
			int il = arr1[0].length;

			int[][] r = new int[l][il];
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < il; j++) {
					r[i][j] = arr1[i][j] + arr2[i][j];
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
