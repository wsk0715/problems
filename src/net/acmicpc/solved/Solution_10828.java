package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_10828 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final ArrayList<Integer> stack = new ArrayList<>();

	// 스택 - S4
	// https://www.acmicpc.net/problem/10828
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			String[] str = readLine().split(" ");
			sol(str);
		}
	}

	public static void sol(String[] str) {
		String command = str[0];
		if (str.length == 1) {
			if (command.equals("pop")) {
				pop();
			} else if (command.equals("size")) {
				size();
			} else if (command.equals("empty")) {
				empty();
			} else if (command.equals("top")) {
				top();
			}
		} else {
			if (command.equals("push")) {
				push(Integer.parseInt(str[1]));
			}
		}
	}

	public static void push(int n) {
		stack.add(n);
	}

	public static void pop() {
		if (stack.size() == 0) {
			System.out.println("-1");
		} else {
			System.out.println(stack.get(stack.size() - 1));
			stack.remove(stack.size() - 1);
		}
	}

	public static void size() {
		System.out.println(stack.size());
	}

	public static void empty() {
		if (stack.size() == 0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}

	public static void top() {
		if (stack.size() == 0) {
			System.out.println("-1");
		} else {
			System.out.println(stack.get(stack.size() - 1));
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

}
