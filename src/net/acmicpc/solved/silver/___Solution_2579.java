package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_2579 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 계단 오르기 - S3
	// https://www.acmicpc.net/problem/2579
	public static void main(String[] args) throws IOException {
		int N = readInt();

		// 계단이 하나인 경우
		if (N == 1) {
			write(readInt());
			close();
			return;
		}

		int[] scores = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			scores[i] = readInt();
		}

		int[] dp = new int[N + 1];
		dp[1] = scores[1];
		dp[2] = scores[2] + scores[1];
		for (int i = 3; i <= N; i++) {
			// 점화식 조건
			// 1. 계단을 한 칸 또는 두 칸 오를 수 있으며,
			// -> 현재 계단에 오르기 위해 i-2, i-1에서 오는 경우를 비교한다.
			int condA = dp[i - 2];
			// 2.연속되는 세 개의 계단을 밟을 수 없다.
			// -> i-1 계단에서 현재 계단에 오르기 위해서는 반드시 i-2를 건너뛰어야 한다.
			int condB = dp[i - 3] + scores[i - 1];

			dp[i] = scores[i] + Math.max(condA, condB);
		}

		write(dp[N]);

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
