package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181929 {
	// 원소들의 곱과 합
	// https://school.programmers.co.kr/learn/courses/30/lessons/181929
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr) {
			int v1 = 1;
			int v2 = 0;
			for (int i = 0; i < arr.length; i++) {
				v1 *= arr[i];
				v2 += arr[i];
			}
			v2 *= v2;

			return v1 < v2 ? 1 : 0;
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
