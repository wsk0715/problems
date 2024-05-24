package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1357 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 뒤집힌 덧셈 - B1
	// https://www.acmicpc.net/problem/1357
	public static void main(String[] args) throws IOException {
		String[] input = readLine().split(" ");
		String s1 = input[0];
		String s2 = input[1];

		int n = reverse(s1) + reverse(s2);
		int m = reverse(String.valueOf(n));
		System.out.println(m);
	}

	private static int reverse(String s) {
		StringBuffer sbf = new StringBuffer(s);
		int n = Integer.parseInt(sbf.reverse()
									.toString());
		return n;
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine()
									   .trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
