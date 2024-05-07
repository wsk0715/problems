package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181857 {
	// 배열의 길이를 2의 거듭제곱으로 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181857
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr) {
			int l = arr.length;
			int t = 1;

			while (t < l) {
				t *= 2;
			}

			int[] r = new int[t];
			for (int i = 0; i < arr.length; i++) {
				r[i] = arr[i];
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
