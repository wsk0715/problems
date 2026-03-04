package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1970. 쉬운 거스름돈 (D2)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PsIl6AXIDFAUq
 */
public class Solution_1970 {

	static int[] coins = new int[]{
			50_000,
			10_000,
			5_000,
			1_000,
			500,
			100,
			50,
			10};

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");

			int N = nextInt();

			for (int i = 0; i < 8; i++) {
				int val = N / coins[i];

				sb.append(val).append(" ");

				N %= coins[i];
			}

			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}


	// Libraries
	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
