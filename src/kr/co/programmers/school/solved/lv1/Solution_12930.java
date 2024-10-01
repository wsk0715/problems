package kr.co.programmers.school.solved.lv1;

public class Solution_12930 {

	// 이상한 문자 만들기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12930
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		String s = "try hello world";
		System.out.println(sol.solution(s));
	}

	static class Solution {

		public String solution(String s) {
			StringBuilder answer = new StringBuilder(s);

			int idx = 0;
			for (int i = 0; i < answer.length(); i++) {
				if (answer.charAt(i) == ' ') {
					idx = 0;
				} else {
					if (idx % 2 == 0) {
						answer.replace(i, i + 1, String.valueOf(answer.charAt(i)).toUpperCase());
					} else {
						answer.replace(i, i + 1, String.valueOf(answer.charAt(i)).toLowerCase());
					}
					idx += 1;
				}
			}

			return answer.toString();
		}

	}

}
