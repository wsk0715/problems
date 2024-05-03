package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181840 {
	// 정수 찾기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181840
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr, int n) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == n) {
					return 1;
				}
			}
			return 0;
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
