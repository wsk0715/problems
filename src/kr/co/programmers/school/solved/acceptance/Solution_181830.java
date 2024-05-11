package kr.co.programmers.school.solved.acceptance;

public class Solution_181830 {
	// 정사각형으로 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181830
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[][] solution(int[][] arr) {
			int rows = arr.length;
			int cols = arr[0].length;
			int l = Math.max(rows, cols);

			int[][] r = new int[l][l];
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					try {
						r[i][j] = arr[i][j];
					} catch (ArrayIndexOutOfBoundsException ignored) {

					}
				}
			}
			return r;
		}

	}

}
