package kr.co.programmers.school.solved;

public class Solution_12925 {
	// 문자열을 정수로 바꾸기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12925
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String s) {
			boolean minus = false;
			if (s.charAt(0) == '-') {
				s = s.replace("-", "");
				minus = true;
			} else if (s.charAt(0) == '+') {
				s = s.replace("+", "");
			}
			int n = Integer.parseInt(s);

			return minus ? -n : n;
		}

	}

}
