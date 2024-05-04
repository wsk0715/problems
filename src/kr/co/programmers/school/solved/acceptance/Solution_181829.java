package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181829 {
	// 이차원 대각선 배열 순회하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181829
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[][] board, int k) {
			int sum = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (i + j <= k) {
						sum += board[i][j];
					}
				}
			}
			return sum;
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
