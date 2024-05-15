package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2231 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 분해합 - B2
	// https://www.acmicpc.net/problem/2231
	public static void main(String[] args) throws IOException {
		int n = readInt();

		int r = 0;
		for (int i = 1; i < n; i++) {
			int m = i;

			String s = String.valueOf(m);
			for (int j = 0; j < s.length(); j++) {
				m += s.charAt(j) - 48;
			}

			if (m == n) {
				r = i;
				break;
			}
		}

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
