package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class __Solution_181880 {
	// 1로 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181880
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] input = {12, 4, 15, 1, 14};
		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] num_list) {
			int r = 0;
			for (int i = 0; i < num_list.length; i++) {
				r += calc(num_list[i], 0);
			}
			return r;
		}

		public int calc(int n, int t) {
			// 1이라면, 횟수 반환
			if (n == 1) {
				return t;
			}
			// 짝수라면
			if (n % 2 == 0) {
				return calc(n / 2, t + 1);
			}
			// 홀수라면
			return calc((n - 1) / 2, t + 1);
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
