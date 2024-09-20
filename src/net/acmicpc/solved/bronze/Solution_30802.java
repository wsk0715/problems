package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_30802 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 웰컴 키트 - B3
	// https://www.acmicpc.net/problem/30802
	public static void main(String[] args) throws IOException {
		int N = readInt();   // 참가자 수
		int[] input1 = readIntegers();
		int[] input2 = readIntegers();
		int T = input2[0];
		int P = input2[1];

		int result1 = 0;
		for (double i : input1) {
			result1 += (int) Math.ceil(i / T);
		}
		write(result1);

		String result2 = String.format("%s %s", N / P, N % P);
		write(result2);

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
