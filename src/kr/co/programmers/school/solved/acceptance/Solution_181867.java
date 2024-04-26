package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181867 {
	// x 사이의 개수
	// https://school.programmers.co.kr/learn/courses/30/lessons/181867
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(String s) {
			String[] arr = s.split("x");
			int[] r = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				r[i] = arr[i].length();
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
