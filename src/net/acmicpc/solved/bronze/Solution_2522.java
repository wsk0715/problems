package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_2522 {
	// 별 찍기 - 12 - B3
	// https://www.acmicpc.net/problem/2522
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		for (int i = -input + 1; i <= input - 1; i++) {
			int j = i;
			if (j < 0) {
				j = -j;
			}
			for (int l = 0; l < j; l++) {
				System.out.print(" ");
			}
			for (int l = 0; l < input - j; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
