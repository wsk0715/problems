package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _Solution_11726 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 2xn 타일링 - S3
	// https://www.acmicpc.net/problem/11726
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 타일 종류는 1x2, 2x1이 있다.
		int[] dp = new int[1001];
		// n = 1인 경우, 2x1 타일이 하나 들어간다.
		dp[1] = 1;
		// n = 2인 경우, 두 가지로 나뉜다.
		// 1. 1x2 타일을 나란히 넣는 경우
		// 2. 2x1 타일을 나란히 넣는 경우
		dp[2] = 2;
		// n = 3인 경우
		// 1. 이미 존재하는 n=2인 경우에 1x2 타일을 하나 놓는 경우 -> dp[n-1]
		// 2. 이미 존재하는 n=1인 경우에 2x1 타일을 나란히 놓는 경우, 1x2타일을 놓는 경우는 1번 경우와 중복된다. -> dp[n-2]

		// 점화식 도출, i >= 3
		// dp[i] = dp[i-1] + dp[i-2]


		// 계산
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
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
