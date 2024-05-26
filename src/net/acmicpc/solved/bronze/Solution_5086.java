package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_5086 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 배수와 약수 - B3
	// https://www.acmicpc.net/problem/5086
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] inputs = readIntegers();
			int n = inputs[0];
			int m = inputs[1];
			if (n == 0 && m == 0) {
				break;
			}

			if (m % n == 0) {
				write("factor");
			} else if (n % m == 0) {
				write("multiple");
			} else {
				write("neither");
			}
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
