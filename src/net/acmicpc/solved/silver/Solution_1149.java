package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1149 {

	static int N, M;

	// RGB거리 - S1
	// https://www.acmicpc.net/problem/1149
	public static void main(String[] args) throws IOException {

		N = nextInt();

		int[][] costs = new int[N][3];  // [R, G, B]
		for (int i = 0; i < costs.length; i++) {
			costs[i] = new int[]{nextInt(), nextInt(), nextInt()};
		}

		// dp[n][?] = min(dp[n-1][R], dp[n-1][G], dp[n-1][B])) + costs[n][?]
		int[][] dp = new int[N][3];  // [R, G, B]
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
		}

		int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
		write(result);

		close();
	}


	// Libraries
	private static StringTokenizer readLine() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	private static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = readLine();
		}
		return Integer.parseInt(st.nextToken());
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

}
