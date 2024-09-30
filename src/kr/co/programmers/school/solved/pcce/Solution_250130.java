package kr.co.programmers.school.solved.pcce;

import java.util.Scanner;

public class Solution_250130 {

	// 저축
	// https://school.programmers.co.kr/learn/courses/30/lessons/250130
	public static void main(String[] args) {
		Solution sol = new Solution();

		//		int[] input = {};
		//		sol.solution(input);
	}

	static class Solution {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int start = sc.nextInt();
			int before = sc.nextInt();
			int after = sc.nextInt();

			int money = start;
			int month = 1;
			while (money < 70) {
				money += before;
				month++;
			}
			while (money < 100) {
				money += after;
				month++;
			}

			System.out.println(month);
		}

	}

}
