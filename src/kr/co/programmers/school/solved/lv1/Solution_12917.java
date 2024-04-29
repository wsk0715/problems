package kr.co.programmers.school.solved.lv1;

import java.util.Arrays;

public class Solution_12917 {
	// 문자열 배치하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12917
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			char[] arr = new char[s.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.charAt(i);
			}
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for (int i = arr.length - 1; i >= 0; i--) {
				sb.append(arr[i]);
			}
			return sb.toString();
		}

	}

}
