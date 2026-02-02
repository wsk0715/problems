package com.swexpertacademy.solved.D2;

import java.io.IOException;
import java.util.Scanner;

public class Solution_1984 {

	// 1984. 중간 평균값 구하기 (D2)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pw_-KAdcDFAUq
	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int max = -1;
			int min = 10001;
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				int n = sc.nextInt();
				sum += n;

				if (n > max) {
					max = n;
				}

				if (n < min) {
					min = n;
				}
			}
			int result = (int) Math.round(((double) sum - max - min) / 8);
			System.out.printf("#%s %s\n", i + 1, result);
		}
	}


	// Libraries
	static Scanner sc = new Scanner(System.in);

}
