package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_17608 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final Stack st = new Stack();

	// 막대기 - B2
	// https://www.acmicpc.net/problem/17608
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			int m = readInt();
			st.push(m);
		}
		int count = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			int l = st.pop();
			if (l > max) {
				count++;
				max = l;
			}
		}
		System.out.println(count);
	}

	public static class Stack {
		private static final ArrayList<Integer> st = new ArrayList<>();

		public static void push(int n) {
			st.add(n);
		}

		public static int pop() {
			int n = -1;
			if (st.size() > 0) {
				n = st.get(st.size() - 1);
				st.remove(st.size() - 1);
			}
			return n;
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
