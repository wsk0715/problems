package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_2810 {
	// 컵홀더 - B1
	// https://www.acmicpc.net/problem/2810
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		String chairs = "S" + sc.nextLine();
		chairs = chairs.replace("LL", "S");

		System.out.println(Math.min(chairs.length(), n));
	}

}
