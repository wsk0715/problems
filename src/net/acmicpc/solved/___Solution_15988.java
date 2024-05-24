package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_15988 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 1, 2, 3 더하기 3 - S2
	// https://www.acmicpc.net/problem/15988
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// n을 1,2,3의 합으로 나타내는 방법의 수 구한 후, 1_000_000_009로 나눈 나머지 출력
		// n을 만드는 방법은 3가지이다:
		// 1. 기존 방법에 구한 수에 1을 더하는 경우
		// 2. 2를 더하는 경우
		// 3. 3을 더하는 경우
		// 1 + 2 + 3이 n을 만드는 방법의 수가 된다.

		long[] dp = new long[1_000_001];
		dp[3] = 4;
		dp[2] = 2;
		dp[1] = 1;

		for (int i = 4; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
		}

		for (int i = 0; i < n; i++) {
			write(dp[readInt()]);
		}

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
