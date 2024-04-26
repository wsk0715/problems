package kr.co.programmers.school.solved.beginner;

import java.util.Scanner;

public class Solution_120823 {
	// 직각삼각형 출력하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120823
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
