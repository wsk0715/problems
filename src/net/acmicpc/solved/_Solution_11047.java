package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_11047 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 동전 0 - S4
	// https://www.acmicpc.net/problem/11047
	public static void main(String[] args) throws IOException {
		int[] inputs = Arrays.stream(readLine().split(" "))
							 .mapToInt(Integer::parseInt)
							 .toArray();
		int N = inputs[0];
		int K = inputs[1];

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = readInt();
		}

		int n = 0;
		for (int i = N - 1; i >= 0; i--) {
			int coin = coins[i];
			if (K >= coin) {
				n += K / coin;
				K %= coin;
			}
		}
		System.out.println(n);
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
