package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181942 {
	// 문자열 섞기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181942
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String str1, String str2) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str1.length() + str2.length(); i++) {
				if (i % 2 == 0) {
					sb.append(str1.charAt(i / 2));
					continue;
				}
				sb.append(str2.charAt(i / 2));
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
