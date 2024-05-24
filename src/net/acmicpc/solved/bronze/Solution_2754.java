package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_2754 {
	private static final Scanner sc = new Scanner(System.in);

	// 학점계산 - B3
	// https://www.acmicpc.net/problem/2754
	public static void main(String[] args) {
		String input = readLine();

		double score = 0;
		char main = input.charAt(0);
		char sub = main != 'F' ? input.charAt(1) : ' ';

		if (main == 'A') {
			score = 4;
		} else if (main == 'B') {
			score = 3;
		} else if (main == 'C') {
			score = 2;
		} else if (main == 'D') {
			score = 1;
		}

		if (sub == '+') {
			score += 0.3;
		} else if (sub == '-') {
			score -= 0.3;
		}

		System.out.printf("%.1f", score);
	}


	// Libraries
	private static String readLine() {
		return sc.nextLine();
	}

}
