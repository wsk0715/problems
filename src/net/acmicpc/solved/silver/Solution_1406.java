package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_1406 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 에디터 - S2
	// https://www.acmicpc.net/problem/1406
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder(readLine());
		int n = readInt();

		int pointer = sb.length();
		for (int i = 0; i < n; i++) {
			String[] input = readLine().split(" ");
			String command = input[0];

			switch (command) {
				case "L":
					if (pointer != 0) {
						pointer -= 1;
					}
					break;
				case "D":
					if (pointer < sb.length()) {
						pointer += 1;
					}
					break;
				case "B":
					if (pointer != 0) {
						sb.delete(pointer - 1, pointer);
						pointer -= 1;
					}
					break;
				case "P":
					String c = input[1];
					sb.insert(pointer, c);
					pointer += 1;
					break;
			}
		}
		write(sb);

		close();
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
