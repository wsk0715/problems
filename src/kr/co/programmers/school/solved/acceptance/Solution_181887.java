package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181887 {
	// 홀수 vs 짝수
	// https://school.programmers.co.kr/learn/courses/30/lessons/181887
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr) {
			int even = 0;
			int odd = 0;
			for (int i = 0; i < arr.length; i++) {
				int n = arr[i];
				if ((i + 1) % 2 == 0) {
					even += n;
					continue;
				}
				odd += arr[i];
			}
			return Math.max(even, odd);
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
