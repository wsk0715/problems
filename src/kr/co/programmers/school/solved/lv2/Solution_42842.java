package kr.co.programmers.school.solved.lv2;

import java.util.Arrays;

public class Solution_42842 {

	// 카펫 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/42842
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int brown = 10;
		int yellow = 2;
		System.out.println(Arrays.toString(sol.solution(brown, yellow)));
		// #case 2
		int brown2 = 8;
		int yellow2 = 1;
		System.out.println(Arrays.toString(sol.solution(brown2, yellow2)));
		// #case 3
		int brown3 = 24;
		int yellow3 = 24;
		System.out.println(Arrays.toString(sol.solution(brown3, yellow3)));
	}

	static class Solution {

		public int[] solution(int brown, int yellow) {
			int[] answer = {};

			// a. brown + 4 = 네 변의 합
			// -> brown / 2 + 2 = 가로 + 세로
			int sum = brown / 2 + 2;

			// b. brown + yellow = 가로(x) * 세로(y)
			for (int x = 0; x <= 5000; x++) {
				for (int y = 0; y <= 5000; y++) {
					if (x >= y && x + y == sum && x * y == brown + yellow) {
						return new int[]{x, y};
					}
				}
			}

			return answer;
		}

	}

}
