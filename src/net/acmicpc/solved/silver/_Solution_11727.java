package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_11727 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 2xn 타일링 2 - S3
	// https://www.acmicpc.net/problem/11727
	public static void main(String[] args) throws IOException {
		int n = readInt();

		int[] dp = new int[1001];
		// 타일 종류는 1x2(a), 2x1(b), 2x2(c)가 있다.
		// n = 1인 경우: 1
		// 1. a
		dp[1] = 1;
		// n = 2인 경우: 3
		// 1. aa
		// 2. bb
		// 3. c
		dp[2] = 3;
		// n = 3인 경우: 5
		// n=2인 경우와 n=1인 경우를 이용한다.
		// 1. n=2인 경우 이용: (aa)a, (bb)a, (c)a
		// 2. n=1인 경우 이용: (a)bb, (a)c -> (a)aa는 1번과 중복되므로 제거

		// 점화식 도출, i >= 3
		// dp[i] = dp[i - 1] + 2 * dp[i - 2]


		// 계산
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
		}
		write(dp[n]);

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
