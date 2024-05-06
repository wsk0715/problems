package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181939 {
	// 더 크게 합치기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181939
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int a, int b) {
			int c1 = Integer.parseInt(String.valueOf(a) + b);
			int c2 = Integer.parseInt(String.valueOf(b) + a);

			return Math.max(c1, c2);
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
