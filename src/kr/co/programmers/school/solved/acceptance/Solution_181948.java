package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181948 {
	// 특수문자 출력하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181948
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public static void main(String[] args) {
			System.out.println("!@#$%^&*(\\'\"<>?:;");
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
