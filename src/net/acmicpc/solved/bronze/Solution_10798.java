package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_10798 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 세로읽기 - B1
	// https://www.acmicpc.net/problem/10798
	public static void main(String[] args) throws IOException {
		String[] input = new String[5];
		for (int i = 0; i < input.length; i++) {
			input[i] = readLine();
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (input[j].length() > i) {
					sb.append(input[j].charAt(i));
				}
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
