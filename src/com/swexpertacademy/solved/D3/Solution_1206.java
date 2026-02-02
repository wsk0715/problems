package com.swexpertacademy.solved.D3;

import java.io.IOException;
import java.util.Scanner;

public class Solution_1206 {

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
				int max = -1;
				for (int k = -2; k <= 2; k++) {
					if (k == 0) {
						continue;
					}
					if (max < buildings[j - k]) {
						max = buildings[j - k];
					}
				}
				result += Math.max(buildings[j] - max, 0);
			}
			System.out.printf("#%s %s\n", i + 1, result);
		}
	}


	// Libraries
	static Scanner sc = new Scanner(System.in);

}
