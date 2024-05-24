package net.acmicpc.solved.bronze;

import java.util.Scanner;

public class Solution_25501 {
	// 재귀의 귀재 - B2
	// https://www.acmicpc.net/problem/25501
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = Integer.parseInt(sc.nextLine());

		String[] arr = new String[input];
		for (int i = 0; i < input; i++) {
			arr[i] = sc.nextLine();
		}
		for (int i = 0; i < input; i++) {
			System.out.printf("%d %d\n", isPalindrome(arr[i])[0], isPalindrome(arr[i])[1]);
		}
	}

	public static int[] recursion(String string, int left, int right, int count) {
		count++;
		if (left >= right) {
			return new int[]{1, count};
		} else if (string.charAt(left) != string.charAt(right)) {
			return new int[]{0, count};
		} else {
			return recursion(string, left + 1, right - 1, count);
		}
	}

	public static int[] isPalindrome(String string) {
		return recursion(string, 0, string.length() - 1, 0);
	}

}

