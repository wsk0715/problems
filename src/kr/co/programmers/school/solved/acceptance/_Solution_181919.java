package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181919 {
	// 콜라츠 수열 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181919
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int n) {
			ArrayList<Integer> al = new ArrayList<>();
			while (true) {
				al.add(n);
				if (n == 1) {
					break;
				}
				n = calc(n);
			}
			return toArray(al);
		}

		public int calc(int n) {
			if (n % 2 == 0) {
				return n / 2;
			}
			return n * 3 + 1;
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
