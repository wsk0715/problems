package kr.co.programmers.school.solved;

public class Solution_120888 {
	// 중복된 문자 제거
	// https://school.programmers.co.kr/learn/courses/30/lessons/120888
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "We are the world";
		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			StringBuilder sb = new StringBuilder();
			int[] counts = new int[1_000];
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);

				if (counts[ch] == 0) {
					sb.append(ch);
					counts[ch]++;
				}
			}
			return sb.toString();
		}

	}

}
