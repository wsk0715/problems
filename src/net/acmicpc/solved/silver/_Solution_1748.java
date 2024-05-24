package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_1748 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 수 이어 쓰기 1 - S4
	// https://www.acmicpc.net/problem/1748
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 1~9: 1
		// 10~99: 2
		// ...
		// 100_000_000: 9

		int r = 0;
		if (n == 100_000_000) {
			r += 9 * 1;
			n -= 1;
		}
		if (n >= 10_000_000) {
			r += 8 * (n - 9_999_999);
			n = 9_999_999;
		}
		if (n >= 1_000_000) {
			r += 7 * (n - 999_999);
			n = 999_999;
		}
		if (n >= 100_000) {
			r += 6 * (n - 99_999);
			n = 99_999;
		}
		if (n >= 10_000) {
			r += 5 * (n - 9999);
			n = 9999;
		}
		if (n >= 1000) {
			r += 4 * (n - 999);
			n = 999;
		}
		if (n >= 100) {
			r += 3 * (n - 99);
			n = 99;
		}
		if (n >= 10) {
			r += 2 * (n - 9);
			n = 9;
		}
		r += n;

		System.out.println(r);
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine()
									   .trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
