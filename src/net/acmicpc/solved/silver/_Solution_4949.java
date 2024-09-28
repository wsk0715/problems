package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class _Solution_4949 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 균형잡힌 세상 - S4
	// https://www.acmicpc.net/problem/4949
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		while (true) {
			char[] chars = readLine().toCharArray();
			if (chars[0] == '.' && chars.length == 1) {
				break;
			}

			Stack<Character> stack = new Stack<>();
			boolean isBalanced = true;
			for (char c : chars) {
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						isBalanced = false;
						break;
					}
					stack.pop();
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						isBalanced = false;
						break;
					}
					stack.pop();
				}
			}
			sb.append(isBalanced && stack.isEmpty() ? "yes" : "no").append("\n");
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
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

}
