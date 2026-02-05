package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1961 {

	// 1961. 숫자 배열 회전 (D2)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pq-OKAVYDFAUq
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = nextInt();

					arr90[j][N - 1 - i] = n;
					arr180[N - 1 - i][N - 1 - j] = n;
					arr270[N - 1 - j][i] = n;
				}
			}

			sb.append("#")
			  .append(tc)
			  .append("\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr90[i][j]);
				}
				sb.append(" ");

				for (int j = 0; j < N; j++) {
					sb.append(arr180[i][j]);
				}
				sb.append(" ");

				for (int j = 0; j < N; j++) {
					sb.append(arr270[i][j]);
				}
				sb.append("\n");
			}
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
