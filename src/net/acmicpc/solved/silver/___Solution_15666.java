package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_15666 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] range, result;

	// N과 M (12) - S2
	// https://www.acmicpc.net/problem/15666
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		N = inputs[0];
		M = inputs[1];

		range = readIntegers();
		Arrays.sort(range);

		result = new int[M];
		dfs(0, 0);

		close();
	}

	static void dfs(int start, int depth) throws IOException {
		if (depth == M) {
			String[] numbers = Arrays.stream(result)
									 .mapToObj(String::valueOf)
									 .toArray(String[]::new);
			write(String.join(" ", numbers));
			return;
		}

		int prev = -1;
		for (int i = start; i < N; i++) {
			int current = range[i];
			if (current == prev) {
				continue;
			}

			result[depth] = current;
			prev = current;
			dfs(i, depth + 1);
		}
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
