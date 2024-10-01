package kr.co.programmers.school.solved.pcce;

import java.util.Scanner;

public class Solution_340205 {

	// 수 나누기
	// https://school.programmers.co.kr/learn/courses/30/lessons/340205
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		//		int[] n = {};
		//		System.out.println(sol.solution(n));
	}

	static class Solution {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			int answer = 0;

			while (number > 0) {
				answer += number % 100;
				number /= 100;
			}

			System.out.println(answer);
		}

	}

}
