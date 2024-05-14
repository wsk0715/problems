package kr.co.programmers.school.solved.acceptance;

public class Solution_181943 {
	// 문자열 겹쳐쓰기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181943
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String my_string, String overwrite_string, int s) {
			StringBuilder sb = new StringBuilder(my_string);
			int l = overwrite_string.length();
			sb.replace(s, s + l, overwrite_string);
			return sb.toString();
		}

	}

}
