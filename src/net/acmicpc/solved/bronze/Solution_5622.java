package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_5622 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 다이얼 - B2
	// https://www.acmicpc.net/problem/5622
	public static void main(String[] args) throws IOException {
		char[] word = readLine().toCharArray();

		int r = 0;
		for (char ch : word) {
			if (ch >= 'A') {
				r += 3;
			}
			if (ch >= 'D') {
				r += 1;
			}
			if (ch >= 'G') {
				r += 1;
			}
			if (ch >= 'J') {
				r += 1;
			}
			if (ch >= 'M') {
				r += 1;
			}
			if (ch >= 'P') {
				r += 1;
			}
			if (ch >= 'T') {
				r += 1;
			}
			if (ch >= 'W') {
				r += 1;
			}
		}
		write(r);

		close();
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine().trim());
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private static <T> void write(T value) throws IOException {
		String s = String.valueOf(value);
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

}
