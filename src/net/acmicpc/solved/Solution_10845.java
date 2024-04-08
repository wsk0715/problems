package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_10845 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final ArrayList<Integer> q = new ArrayList<>();

	// 큐 - S4
	// https://www.acmicpc.net/problem/10845
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			String[] s = readLine().split(" ");
			switch (s[0]) {
				case "push":
					push(Integer.parseInt(s[1]));
					break;
				case "pop":
					pop();
					break;
				case "size":
					size();
					break;
				case "empty":
					empty();
					break;
				case "front":
					front();
					break;
				case "back":
					back();
					break;
			}
		}
	}

	private static void back() {
		System.out.println(q.isEmpty() ? -1 : q.get(q.size() - 1));
	}

	private static void front() {
		System.out.println(q.isEmpty() ? -1 : q.get(0));
	}

	private static void empty() {
		System.out.println(q.isEmpty() ? 1 : 0);
	}

	private static void size() {
		System.out.println(q.size());
	}

	private static void pop() {
		System.out.println(q.isEmpty() ? -1 : q.remove(0));
	}

	private static void push(int s) {
		q.add(s);
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
