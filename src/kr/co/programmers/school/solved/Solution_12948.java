package kr.co.programmers.school.solved;

public class Solution_12948 {
	// 핸드폰 번호 가리기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12948
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder(s);
			for (int i = 0; i < sb.length() - 4; i++) {
				sb.replace(i, i + 1, "*");
			}
			return sb.toString();
		}

	}

}
