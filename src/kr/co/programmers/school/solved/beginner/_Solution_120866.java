package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120866 {
	// 안전지대
	// https://school.programmers.co.kr/learn/courses/30/lessons/120866
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[][] input = {
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 1, 1, 0},
				{0, 0, 0, 0, 0}};
		sol.solution(input);
	}

	static class Solution {
		public int solution(int[][] b) {
			int r = 0;

			// 가장자리에 가상의 경계를 이어붙인, 새로운 보드 생성(크기: n+2 * n+2)
			int[][] board = new int[b.length + 2][b.length + 2];
			for (int i = 1; i < board.length - 1; i++) {
				for (int j = 1; j < board.length - 1; j++) {
					board[i][j] = b[i - 1][j - 1];
				}
			}

			// 게임 실행
			for (int i = 1; i < board.length - 1; i++) {
				for (int j = 1; j < board.length - 1; j++) {  // 정사각형 보드
					if (board[i][j] != 1) {  // 지뢰가 아니면, 무시
						continue;
					}
					calc(board, i, j);
				}
			}

			// 결과 계산
			for (int i = 1; i < board.length - 1; i++) {
				for (int j = 1; j < board.length - 1; j++) {
					if (board[i][j] == 0) {
						r += 1;
					}
				}
			}

			return r;
		}

		private void calc(int[][] board, int i, int j) {
			for (int k = -1; k <= 1; k++) {
				for (int l = -1; l <= 1; l++) {
					int a = i + k;
					int b = j + l;
					if (board[a][b] == 1) {  // 인접 블럭이 지뢰이면, 무시
						continue;
					}
					board[a][b] = 2;
				}
			}
		}

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
