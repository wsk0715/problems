package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2745 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 진법 변환 - B2
	// https://www.acmicpc.net/problem/2745
	public static void main(String[] args) throws IOException {
		String[] input = readLine().split(" ");
		String str = input[0];
		int n = Integer.parseInt(input[1]);

		System.out.println(sol(str, n));
	}

	private static int sol(String str, int n) {
		int sum = 0;
		int len = str.length() - 1;
		for (int i = len; i >= 0; i--) {
			int value = str.charAt(i);
			if (value >= 'A') {
				value = value - 'A' + 10;
			} else {
				value = value - '0';
			}
			sum += value * Math.pow(n, len - i);  // Math.pow(a, b) - a를 b제곱함
		}
		return sum;
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

}
