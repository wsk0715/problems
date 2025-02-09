package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_18258 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 큐 2 - S4
	// https://www.acmicpc.net/problem/18258
	public static void main(String[] args) throws IOException {
		int N = readInt();

		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String[] command = readLine().split(" ");
			switch (command[0]) {
				case "push":
					deque.add(Integer.parseInt(command[1]));
					break;
				case "pop":
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
						break;
					}
					sb.append(deque.removeFirst()).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					sb.append(deque.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
						break;
					}
					sb.append(deque.peekFirst()).append("\n");
					break;
				case "back":
					if (deque.isEmpty()) {
						sb.append(-1).append("\n");
						break;
					}
					sb.append(deque.peekLast()).append("\n");
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
