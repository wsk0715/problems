package kr.co.programmers.school.solved.acceptance;

public class Solution_181934 {
	// 조건 문자열
	// https://school.programmers.co.kr/learn/courses/30/lessons/181934
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String ineq, String eq, int n, int m) {
			if (ineq.equals(">")) {
				if (eq.equals("=")) {
					return n >= m ? 1 : 0;
				}
				return n > m ? 1 : 0;
			}

			if (eq.equals("=")) {
				return n <= m ? 1 : 0;
			}
			return n < m ? 1 : 0;
		}

	}

}
