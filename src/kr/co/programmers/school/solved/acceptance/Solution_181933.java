package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181933 {
	// flag에 따라 다른 값 반환하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181933
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int a, int b, boolean flag) {
			if (flag) {
				return a + b;
			}
			return a - b;
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
