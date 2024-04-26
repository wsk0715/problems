package kr.co.programmers.school.solved.beginner;

import java.util.Arrays;

public class Solution_120911 {
	// 문자열 정렬하기(2)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120911
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "Bcad";
		sol.solution(input);
	}

	static class Solution {
		public String solution(String my_string) {
			char[] arr = new char[my_string.length()];
			my_string = my_string.toLowerCase();
			for (int i = 0; i < my_string.length(); i++) {
				arr[i] = my_string.charAt(i);
			}
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			return sb.toString();
		}

	}

}
