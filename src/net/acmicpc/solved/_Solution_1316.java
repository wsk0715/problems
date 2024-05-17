package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_1316 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 그룹 단어 체커 - S5
	// https://www.acmicpc.net/problem/1316
	public static void main(String[] args) throws IOException {
		int n = readInt();

		int r = 0;
		for (int i = 0; i < n; i++) {
			String s = readLine();

			r += solve(s);
		}
		System.out.println(r);
	}

	private static int solve(String s) {
		int[] alpha = new int[26];
		char recent = ' ';
		for (int j = 0; j < s.length(); j++) {
			char ch = s.charAt(j);
			if (ch != recent) {
				alpha[ch - 'a'] += 1;
			}
			recent = ch;
		}
		for (int j : alpha) {
			if (j > 1) {
				return 0;
			}
		}
		return 1;
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
