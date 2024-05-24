package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_2442 {
	// 별 찍기 - 5 - B3
	// https://www.acmicpc.net/problem/2442
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			for (int j = input - i; j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

