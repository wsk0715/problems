package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _Solution_3009 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 네 번째 점 - B3
	// https://www.acmicpc.net/problem/3009
	public static void main(String[] args) throws IOException {
		int[] x = new int[3];
		int[] y = new int[3];
		for (int i = 0; i < 3; i++) {
			int[] input = readIntegers();
			x[i] = input[0];
			y[i] = input[1];
		}

		int x4, y4;
		if (x[0] == x[1]) {
			x4 = x[2];
		} else if (x[0] == x[2]) {
			x4 = x[1];
		} else {
			x4 = x[0];
		}

		if (y[0] == y[1]) {
			y4 = y[2];
		} else if (y[0] == y[2]) {
			y4 = y[1];
		} else {
			y4 = y[0];
		}

		write(x4 + " " + y4);

		close();
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	private static int[] readIntegers() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[st.countTokens()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
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
