package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181834 {
	// l로 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181834
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch <= 108) {
					sb.append("l");
					continue;
				}
				sb.append(ch);
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
