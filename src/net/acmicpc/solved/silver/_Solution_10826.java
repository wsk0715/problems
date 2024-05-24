package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class _Solution_10826 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 피보나치 수 4 - S5
	// https://www.acmicpc.net/problem/10826
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 피보나치 수열 - DP
		String result = null;
		if (n == 0) {
			result = "0";
		} else if (n == 1) {
			result = "1";
		} else {
			BigInteger[] dp = new BigInteger[n + 1];
			dp[0] = new BigInteger(String.valueOf(0));
			dp[1] = new BigInteger(String.valueOf(1));

			for (int i = 2; i < dp.length; i++) {
				dp[i] = dp[i - 1].add(dp[i - 2]);
			}
			result = String.valueOf(dp[n]);
		}
		write(result);
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
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

}
