package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Solution_28278 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 스택 2 - S4
	// https://www.acmicpc.net/problem/28278
	public static void main(String[] args) throws IOException {
		int N = readInt();

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int[] command = readIntegers();

			switch (command[0]) {
				case 1:
					stack.push(command[1]);
					break;
				case 2:
					if (!stack.isEmpty()) {
						sb.append(stack.pop()).append("\n");
						break;
					}
					sb.append(-1).append("\n");
					break;
				case 3:
					sb.append(stack.size()).append("\n");
					break;
				case 4:
					sb.append(stack.isEmpty() ? 1 : 0).append("\n");
					break;
				case 5:
					if (!stack.isEmpty()) {
						sb.append(stack.peek()).append("\n");
						break;
					}
					sb.append(-1).append("\n");
					break;
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
