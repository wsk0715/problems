package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181905 {
	// 문자열 뒤집기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181905
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String my_string, int s, int e) {
			StringBuilder sb = new StringBuilder(my_string);
			StringBuilder ss = new StringBuilder((my_string.substring(s, e + 1)));
			return sb.replace(s, e + 1, ss.reverse()
										  .toString())
					 .toString();
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
