package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181841 {
	// 꼬리 문자열
	// https://school.programmers.co.kr/learn/courses/30/lessons/181841
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String[] arr, String s) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].contains(s)) {
					continue;
				}
				sb.append(arr[i]);
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
