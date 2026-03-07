package com.swexpertacademy.solved.D1;

import java.io.IOException;
import java.util.Scanner;

public class Solution_2068 {

	// 2068. 최대수 구하기 (D1)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QQhbqA4QDFAUq
	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int max = -1;
			for (int j = 0; j < 10; j++) {
				int n = sc.nextInt();
				if (n > max) {
					max = n;
				}
			}
			System.out.printf("#%s %s\n", i + 1, max);
		}
	}


	// Libraries
	static Scanner sc = new Scanner(System.in);

}
