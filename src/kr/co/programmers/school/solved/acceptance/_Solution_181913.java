package kr.co.programmers.school.solved.acceptance;

public class _Solution_181913 {
	// 문자열 여러 번 뒤집기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181913
	public static void main(String[] args) {
		Solution sol = new Solution();

		sol.solution("rermgorpsam", new int[][]{{2, 3}, {0, 7}, {5, 9}, {6, 10}});
	}

	static class Solution {
		public String solution(String my_string, int[][] queries) {
			StringBuilder sb = new StringBuilder(my_string);
			for (int i = 0; i < queries.length; i++) {
				int s = queries[i][0];
				int e = queries[i][1];
				StringBuilder tmp = new StringBuilder(sb.substring(s, e + 1));
				sb.replace(s, e + 1, tmp.reverse()
										.toString());
			}
			return sb.toString();
		}

	}

}
