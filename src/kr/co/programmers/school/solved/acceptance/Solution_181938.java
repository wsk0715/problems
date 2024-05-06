package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181938 {
	// 두 수의 연산값 비교하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181938
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int a, int b) {
			int c1 = Integer.parseInt(String.valueOf(a) + b);
			int c2 = 2 * a * b;

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
