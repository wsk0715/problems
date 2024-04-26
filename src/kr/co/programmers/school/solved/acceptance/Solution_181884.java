package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181884 {
	// n보다 커질 때까지 더하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181884
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr, int n) {
			int r = 0;
			for (int i = 0; i < arr.length; i++) {
				r += arr[i];
				if (r > n) {
					return r;
				}
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
