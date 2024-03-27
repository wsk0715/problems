package kr.co.programmers.school.solved;

public class Solution_120860 {
	// 직사각형 넓이 구하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120860
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[][] dots) {
			int w = 0, h = 0;
			for (int i = 0; i < dots.length - 1; i++) {
				if (dots[i][0] == dots[i + 1][0]) {

				} else {
					w = dots[i][0] - dots[i + 1][0];
				}
			}
			for (int i = 0; i < dots.length - 1; i++) {
				if (dots[i][1] == dots[i + 1][1]) {

				} else {
					h = dots[i][1] - dots[i + 1][1];
				}
			}

			int result = (w * h >= 0) ? w * h : -w * h;
			return result;
		}

	}

}
