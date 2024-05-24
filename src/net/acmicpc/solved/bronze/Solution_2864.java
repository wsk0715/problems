package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_2864 {
	// 5와 6의 차이 - B2
	// https://www.acmicpc.net/problem/2864
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");

		String[] mins = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			mins[i] = input[i].replace("6", "5");
		}
		String[] maxs = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			maxs[i] = input[i].replace("5", "6");
		}

		System.out.printf("%s %s", getSum(mins), getSum(maxs));
	}

	public static int getSum(String[] strings) {
		int sum = 0;
		for (String str : strings) {
			sum += Integer.parseInt(str);
		}
		return sum;
	}

}

