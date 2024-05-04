package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181831 {
	// 특별한 이차원 배열2
	// https://school.programmers.co.kr/learn/courses/30/lessons/181831
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[][] arr) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] != arr[j][i]) {
						return 0;
					}
				}
			}
			return 1;
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
