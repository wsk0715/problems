package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181903 {
	// qr code
	// https://school.programmers.co.kr/learn/courses/30/lessons/181903
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(int q, int r, String code) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < code.length(); i++) {
				if (i % q == r) {
					sb.append(code.charAt(i));
				}
			}
			return sb.toString();
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
