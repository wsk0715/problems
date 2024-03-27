package kr.co.programmers.school.solved;

public class Solution_120834 {
	// 외계행성의 나이
	// https://school.programmers.co.kr/learn/courses/30/lessons/120834
	public static void main(String[] args) {
		Solution sol = new Solution();

		int input = 23;
		sol.solution(input);
	}

	static class Solution {
		public String solution(int age) {
			String strAge = String.valueOf(age);
			StringBuilder sb = new StringBuilder();

			System.out.println(age);
			for (int i = 0; i < strAge.length(); i++) {
				sb.append((char) (strAge.charAt(i) + 49));
			}

			return sb.toString();
		}

	}

}
