package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_10820 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 문자열 분석 - B2
	// https://www.acmicpc.net/problem/10820
	public static void main(String[] args) throws IOException {
		String input;
		while ((input = readLine()) != null) {
			int[] arr = new int[4];
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == ' ') {
					arr[3] += 1;
					continue;
				}
				if ('0' <= ch && ch <= '9') {
					arr[2] += 1;
					continue;
				}
				if ('A' <= ch && ch <= 'Z') {
					arr[1] += 1;
					continue;
				}
				if ('a' <= ch && ch <= 'z') {
					arr[0] += 1;
				}
			}
			write(String.join(" ", Arrays.stream(arr)
										 .mapToObj(String::valueOf)
										 .toArray(String[]::new)));
		}

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
