package net.acmicpc.solved.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2750 {
	private static final Scanner sc = new Scanner(System.in);

	// 수 정렬하기 - B2
	// https://www.acmicpc.net/problem/2750
	public static void main(String[] args) {
		int n = readInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}

	}

	// Libraries

	private static int readInt() {
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}

}

