package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181915 {
	// 글자 이어 붙여 문자열 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181915
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s, int[] arr) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(s.charAt(arr[i]));
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
