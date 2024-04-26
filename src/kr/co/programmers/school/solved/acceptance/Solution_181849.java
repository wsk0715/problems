package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181849 {
	// 문자열 정수의 합
	// https://school.programmers.co.kr/learn/courses/30/lessons/181849
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String s) {
			return s.chars().map(n -> n - 48).sum();
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
