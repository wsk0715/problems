package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _Solution_7568 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 덩치 - S5
	// https://www.acmicpc.net/problem/7568
	public static void main(String[] args) throws IOException {
		int N = readInt();

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i] = readIntegers();
		}

		int[] ranks = new int[N];
		for (int i = 0; i < arr.length; i++) {
			int rank = 1;

			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank += 1;
				}
			}
			ranks[i] = rank;
		}
		write(Arrays.stream(ranks)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" ")));

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
