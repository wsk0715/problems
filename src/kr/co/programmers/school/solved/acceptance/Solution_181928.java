package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181928 {
	// 이어 붙인 수
	// https://school.programmers.co.kr/learn/courses/30/lessons/181928
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr) {
			StringBuilder even = new StringBuilder();
			StringBuilder odd = new StringBuilder();

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 == 0) {
					even.append(arr[i]);
					continue;
				}
				odd.append(arr[i]);
			}
			return Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
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
