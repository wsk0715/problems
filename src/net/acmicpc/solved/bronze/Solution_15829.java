package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_15829 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final int r = 31;
	private static final int M = 1234567891;

	// Hashing - B2
	// https://www.acmicpc.net/problem/15829
	public static void main(String[] args) throws IOException {
		int l = readInt();
		String target = readLine();

		long sum = 0;
		for (int i = 0; i < l; i++) {
			sum += hash(target.charAt(i), i);
		}
		System.out.println(sum);
	}

	public static long hash(char ch, int i) {
		int value = ch - 96;
		return value * sqr(r, i) % M;
	}

	public static long sqr(int n, int times) {
		long value = 1;
		for (int i = 0; i < times; i++) {
			value *= n;
		}
		return value;
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
