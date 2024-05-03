package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181847 {
	// 0 떼기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181847
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			return String.valueOf(Integer.parseInt(s));
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
