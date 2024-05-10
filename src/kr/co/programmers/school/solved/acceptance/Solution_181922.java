package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181922 {
	// 수열과 구간 쿼리 4
	// https://school.programmers.co.kr/learn/courses/30/lessons/181922
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int[][] queries) {
			for (int i = 0; i < queries.length; i++) {
				for (int j = queries[i][0]; j <= queries[i][1]; j++) {
					if (j % queries[i][2] == 0) {
						arr[j] += 1;
					}
				}
			}
			return arr;
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
