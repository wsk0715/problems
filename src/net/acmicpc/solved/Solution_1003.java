package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1003 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 피보나치 함수 - S3
	// https://www.acmicpc.net/problem/1003
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			int m = readInt();
			sol(m);
		}
	}

	private static void sol(int n) {
		int[] arr = calc(n);
		System.out.printf("%d %d\n", arr[0], arr[1]);
	}

	private static int[] calc(int n) {
		int[][] fibo = new int[41][2];
		fibo[0] = new int[]{1, 0};
		fibo[1] = new int[]{0, 1};
		for (int i = 2; i <= n; i++) {
			int a = fibo[i - 2][0] + fibo[i - 1][0];
			int b = fibo[i - 2][1] + fibo[i - 1][1];
			fibo[i] = new int[]{a, b};
		}
		return fibo[n];
	}


	// Libraries
	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

}
