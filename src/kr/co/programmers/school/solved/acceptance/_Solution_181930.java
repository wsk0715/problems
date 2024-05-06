package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181930 {
	// 주사위 게임 2
	// https://school.programmers.co.kr/learn/courses/30/lessons/181930
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int a, int b, int c) {
			boolean con3Equals = a == b && b == c;
			boolean con2Equals = a == b || b == c || c == a;

			int r = a + b + c;
			if (con2Equals) {
				r *= (a * a + b * b + c * c);
			}
			if (con3Equals) {
				r *= (a * a * a + b * b * b + c * c * c);
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
