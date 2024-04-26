package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181901 {
	// 배열 만들기 1
	// https://school.programmers.co.kr/learn/courses/30/lessons/181901
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int n, int k) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (i % k == 0) {
					al.add(i);
				}
			}
			return toArray(al);
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
