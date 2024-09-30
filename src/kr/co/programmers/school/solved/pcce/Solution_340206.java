package kr.co.programmers.school.solved.pcce;

import java.util.Scanner;

public class Solution_340206 {

	// 각도 합치기
	// https://school.programmers.co.kr/learn/courses/30/lessons/340206
	public static void main(String[] args) {
		Solution sol = new Solution();

		//		int[] input = {};
		//		sol.solution(input);
	}

	static class Solution {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int angle1 = sc.nextInt();
			int angle2 = sc.nextInt();

			int sum_angle = angle1 + angle2;
			System.out.println(sum_angle % 360);
		}

	}

}
