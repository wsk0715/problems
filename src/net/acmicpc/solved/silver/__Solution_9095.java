package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class __Solution_9095 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 1, 2, 3 더하기 - S3
	// https://www.acmicpc.net/problem/9095
	public static void main(String[] args) throws IOException {
		int T = readInt();

		// n을 1,2,3의 합으로 나타내는 경우의 수
		// 1 -> (1) -> 1만으로 이루어지는 경우
		// 2 -> (1)-(1), (2) -> 1-1, 2만으로 이루어지는 경우로 나누어진다.
		// 3 -> (1-1)-(1), (2)-(1), (1)-(2), (3) -> 1-2, 2-1, 3만으로 이루어지는 경우로 나누어진다.
		// 4 -> (1-1-1)-(1), (1-2)-(1), (2-1)-(1), (3)-(1), (1-1)-(2), (2)-(2), (1)-(3) -> 크게 3-1, 2-2, 1-3으로 나누어진다.
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}

		for (int i = 0; i < T; i++) {
			int n = readInt();
			System.out.println(dp[n]);
		}
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
