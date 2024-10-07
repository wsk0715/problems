package kr.co.programmers.school.solved.lv1;

public class _Solution_12926 {

	// 시저 암호 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12926
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "AB";
		int n = 1;
		System.out.println(sol.solution(s, n));
		// #case 2
		String s2 = "z";
		int n2 = 1;
		System.out.println(sol.solution(s2, n2));
		// #case 3
		String s3 = "a B z";
		int n3 = 4;
		System.out.println(sol.solution(s3, n3));
	}

	static class Solution {

		public String solution(String s, int n) {
			// 문자열 s의 각 문자를 n회씩 밀어야 한다.
			// 소문자는 소문자끼리, 대문자는 대문자끼리, 공백은 아무리 밀어도 공백

			StringBuilder sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				if ('A' <= c && c <= 'Z') {
					c += n;
					if ('Z' < c) {
						c -= 26;
					}
				}
				if ('a' <= c && c <= 'z') {
					c += n;
					if ('z' < c) {
						c -= 26;
					}
				}

				sb.append(c);
			}

			return sb.toString();
		}

	}

}
