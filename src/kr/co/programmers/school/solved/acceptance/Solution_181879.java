package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181879 {
	// 길이에 따른 연산
	// https://school.programmers.co.kr/learn/courses/30/lessons/181879
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr) {
			int r = 0;

			int l = arr.length;
			if (l > 10) {
				for (int i = 0; i < l; i++) {
					r += arr[i];
				}
				return r;
			}

			r += 1;
			for (int i = 0; i < l; i++) {
				r *= arr[i];
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
