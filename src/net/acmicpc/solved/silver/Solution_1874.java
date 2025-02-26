package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Solution_1874 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 스택 수열 - S2
	// https://www.acmicpc.net/problem/1874
	public static void main(String[] args) throws IOException {
		int n = readInt();

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int current = 1;
		for (int i = 0; i < n; i++) {
			int target = readInt();

			while (current <= target) {
				stack.push(current++);
				sb.append("+\n");
			}

			if (stack.peek() == target) {
				stack.pop();
				sb.append("-\n");
			} else {
				write("NO");
				close();
				return;
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
