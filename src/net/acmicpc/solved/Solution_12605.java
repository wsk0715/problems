package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_12605 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final Stack st = new Stack();

	// 단어순서 뒤집기 - B2
	// https://www.acmicpc.net/problem/12605
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			String[] arr = readLine().split(" ");
			String[] result = calc(arr);
			System.out.printf("Case #%d:", i + 1);
			for (int j = 0; j < result.length; j++) {
				System.out.printf(" %s", result[j]);
			}
			System.out.println();
		}
	}

	public static String[] calc(String[] arr) {
		String[] s = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			st.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			s[i] = st.pop();
		}

		return s;
	}

	public static class Stack {
		private ArrayList<String> st = new ArrayList<>();

		public void push(String s) {
			st.add(s);
		}

		public String pop() {
			String top = null;
			if (st.size() > 0) {
				top = st.get(st.size() - 1);
				st.remove(st.size() - 1);
			}
			return top;
		}

	}

	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

}
