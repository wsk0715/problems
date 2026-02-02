package com.swexpertacademy.solved.D3;

import java.io.IOException;
import java.util.Scanner;

public class Solution_1206_1 {

	// 1206. View (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh
	public static void main(String[] args) throws IOException {
		int T = 10;
		for (int i = 0; i < T; i++) {
			int b = sc.nextInt();
			int[] buildings = new int[b];
			for (int j = 0; j < b; j++) {
				buildings[j] = sc.nextInt();
			}

			int result = 0;
			for (int j = 2; j < b - 2; j++) {
				int left = Math.max(buildings[j - 2], buildings[j - 1]);
				int right = Math.max(buildings[j + 1], buildings[j + 2]);
				int highest = Math.max(left, right);

				result += Math.max(buildings[j] - highest, 0);
			}
			System.out.printf("#%s %s\n", i + 1, result);
		}
	}


	// Libraries
	static Scanner sc = new Scanner(System.in);

}
