package kr.co.programmers.school.solved.pcce;

import java.util.Scanner;

public class Solution_250131 {

	// 나이 계산
	// https://school.programmers.co.kr/learn/courses/30/lessons/250131
	public static void main(String[] args) {
		Solution sol = new Solution();

		//		int[] input = {};
		//		sol.solution(input);
	}

	static class Solution {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int year = sc.nextInt();
			String age_type = sc.next();
			int answer = 0;

			if (age_type.equals("Korea")) {
				answer = 2030 - year + 1;
			} else if (age_type.equals("Year")) {
				answer = 2030 - year;
			}

			System.out.println(answer);
		}

	}

}
