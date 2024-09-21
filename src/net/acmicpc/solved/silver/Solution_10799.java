package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_10799 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 쇠막대기 - S2
	// https://www.acmicpc.net/problem/10799
	public static void main(String[] args) throws IOException {
		String input = readLine();

		int result = 0;
		char[] arr = input.toCharArray();
		int size = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				size += 1;
			} else if (arr[i] == ')') {
				size -= 1;
				if (i > 0 && arr[i - 1] == '(') {
					result += size;
				} else {
					result += 1;
				}
			}
		}
		write(result);

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
