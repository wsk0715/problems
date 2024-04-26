package kr.co.programmers.school.solved.beginner;

public class Solution_120893 {
	// 대문자와 소문자
	// https://school.programmers.co.kr/learn/courses/30/lessons/120893
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String my_string) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < my_string.length(); i++) {
				char ch = my_string.charAt(i);
				if (65 <= ch && ch <= 90) {
					sb.append(String.valueOf(ch)
									.toLowerCase());
				} else {
					sb.append(String.valueOf(ch)
									.toUpperCase());
				}
			}
			return sb.toString();
		}

	}

}
