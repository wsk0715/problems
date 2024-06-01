package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_11655 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// ROT13 - B1
	// https://www.acmicpc.net/problem/11655
	public static void main(String[] args) throws IOException {
		String s = readLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(rot13(s.charAt(i)));
		}
		write(sb);

		close();
	}

	public static char rot13(char ch) {
		if ('a' <= ch) {
			if ('a' + 13 <= ch) {
				return (char) (ch - 13);
			}
			return (char) (ch + 13);
		}
		if ('A' <= ch) {
			if ('A' + 13 <= ch) {
				return (char) (ch - 13);
			}
			return (char) (ch + 13);
		}
		return ch;
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine()
								  .trim());
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(br.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
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
