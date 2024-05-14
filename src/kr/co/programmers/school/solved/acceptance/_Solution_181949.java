package kr.co.programmers.school.solved.acceptance;

import java.util.Scanner;

public class _Solution_181949 {
	// 대소문자 바꿔서 출력하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181949
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String a = sc.next();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < a.length(); i++) {
				char ch = a.charAt(i);
				if (65 <= ch && ch <= 90) {
					ch += -65 + 97;
				} else if (97 <= ch && ch <= 122) {
					ch += -97 + 65;
				}
				sb.append(ch);
			}
			System.out.println(sb);
		}

	}

}
