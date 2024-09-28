package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_11660 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 구간 합 구하기 5 - S1
	// https://www.acmicpc.net/problem/11660
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		int N = input[0];
		int M = input[1];

		int[][] prefixSumsArr = new int[N + 1][N + 1];
		for (int i = 1; i < prefixSumsArr.length; i++) {
			int[] numbers = readIntegers();

			for (int j = 1; j < prefixSumsArr[i].length; j++) {
				prefixSumsArr[i][j] = (numbers[j - 1] + prefixSumsArr[i - 1][j] + prefixSumsArr[i][j - 1]) - prefixSumsArr[i - 1][j - 1];
			}
		}

		// #logging
		//		for (int[] line : prefixSumsArr) {
		//			write(Arrays.toString(line));
		//		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int[] xy = readIntegers();
			int x1 = xy[0];
			int y1 = xy[1];
			int x2 = xy[2];
			int y2 = xy[3];

			int sum = (prefixSumsArr[x2][y2] - prefixSumsArr[x2][y1 - 1] - prefixSumsArr[x1 - 1][y2]) + prefixSumsArr[x1 - 1][y1 - 1];
			sb.append(sum).append("\n");
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
