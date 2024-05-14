package kr.co.programmers.school.solved.acceptance;

public class _Solution_181932 {
	// 코드 처리하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181932
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String code) {
			StringBuilder ret = new StringBuilder();
			int mode = 0;
			for (int i = 0; i < code.length(); i++) {
				char ch = code.charAt(i);

				if (ch == '1') {
					mode = mode == 1 ? 0 : 1;
					continue;
				}

				if (i % 2 == mode) {
					ret.append(ch);
				}
			}
			return ret.length() == 0 ? "EMPTY" : ret.toString();
		}

	}

}
