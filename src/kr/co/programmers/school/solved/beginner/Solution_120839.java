package kr.co.programmers.school.solved.beginner;

public class Solution_120839 {
	// 가위 바위 보
	// https://school.programmers.co.kr/learn/courses/30/lessons/120839
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String rsp) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < rsp.length(); i++) {
				char ch = rsp.charAt(i);
				if (ch == '0') {
					sb.append(5);
				} else if (ch == '2') {
					sb.append(0);
				} else if (ch == '5') {
					sb.append(2);
				}
			}
			return sb.toString();
		}

	}

}
