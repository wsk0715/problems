package kr.co.programmers.school.solved.pcce;

import java.util.Scanner;

public class Solution_250132 {

	// 피타고라스의 정리
	// https://school.programmers.co.kr/learn/courses/30/lessons/250132
	public static void main(String[] args) {
		Solution sol = new Solution();

		//		int[] input = {};
		//		sol.solution(input);
	}

	static class Solution {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int c = sc.nextInt();

			int b_square = c * c - a * a;

			System.out.println(b_square);
		}

	}

}
