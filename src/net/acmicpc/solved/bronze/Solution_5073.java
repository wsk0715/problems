package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_5073 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 삼각형과 세 변 - B3
	// https://www.acmicpc.net/problem/5073
	public static void main(String[] args) throws IOException {
		while (true) {
			String input = readLine();
			if (input.equals("0 0 0")) {
				break;
			}
			int[] values = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			write(solve(values));
		}

		close();
	}

	public static String solve(int[] values) {
		int a = values[0];
		int b = values[1];
		int c = values[2];
		int max = Math.max(Math.max(a, b), c);

		if (a + b + c - max <= max) {
			return "Invalid";
		}
		if (a == b && b == c) {
			return "Equilateral";
		}
		if (a == b || a == c || b == c) {
			return "Isosceles";
		}

		return "Scalene";
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
