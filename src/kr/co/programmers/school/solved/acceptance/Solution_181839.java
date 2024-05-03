package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181839 {
	// 주사위 게임 1
	// https://school.programmers.co.kr/learn/courses/30/lessons/181839
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int a, int b) {
			boolean oddA = a % 2 != 0;
			boolean oddB = b % 2 != 0;
			if (!oddA && !oddB) {
				return Math.abs(a - b);
			}
			if (oddA && oddB) {
				return a * a + b * b;
			}
			return 2 * (a + b);
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
