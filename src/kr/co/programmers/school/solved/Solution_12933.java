package kr.co.programmers.school.solved;

import java.util.Arrays;

public class Solution_12933 {
	// 정수 내림차순으로 배치하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12933
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public long solution(long n) {
			String s = String.valueOf(n);
			int[] arr = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i) - 48;
			}
			Arrays.sort(arr);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[arr.length - 1 - i]);
			}
			return Long.parseLong(sb.toString());
		}

	}

}
