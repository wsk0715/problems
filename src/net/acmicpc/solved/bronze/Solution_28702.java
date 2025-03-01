package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_28702 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// FizzBuzz - B1
	// https://www.acmicpc.net/problem/28702
	public static void main(String[] args) throws IOException {
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = readLine();
		}

		int current = -1;
		for (int i = 0; i < 3; i++) {
			String s = arr[i];
			if (s.equals("Fizz") || s.equals("Buzz") || s.equals("FizzBuzz")) {
				continue;
			}

			current = Integer.parseInt(s) + (3 - i);
			break;
		}

		String result = fizz(current);
		write(result);

		close();
	}

	static String fizz(int i) {
		if (i % 15 == 0) {
			return "FizzBuzz";
		}
		if (i % 3 == 0) {
			return "Fizz";
		}
		if (i % 5 == 0) {
			return "Buzz";
		}

		return String.valueOf(i);
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
