package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_4673 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 셀프 넘버 - S5
	// https://www.acmicpc.net/problem/4673
	public static void main(String[] args) {
		int[] arr = new int[10_001];
		int[] result = new int[2 * arr.length];
		for (int i = 0; i < arr.length; i++) {
			int r = calc(i);
			result[r] = 1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (result[i] != 1) {
				System.out.println(i);
			}
		}
	}

	private static int calc(int n) {
		String s = String.valueOf(n);

		for (int i = 0; i < s.length(); i++) {
			n += s.charAt(i) - 48;
		}
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
