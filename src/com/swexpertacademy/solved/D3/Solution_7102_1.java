package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7102_1 {

	// 7102. 준홍이의 카드놀이 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIlHWqBYcDFAXC
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int M = nextInt();

			int max = -1;
			int[] counts = new int[N + M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					counts[i + j] += 1;

					if (counts[i + j] > max) {
						max = counts[i + j];
					}
				}
			}

			// List 오버헤드 개선
			sb.append("#")
			  .append(tc);
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] == max) {
					sb.append(" ").append(i);
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}


	// Libraries
	private static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
