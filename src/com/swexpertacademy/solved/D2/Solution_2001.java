package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {

	// 2001. 파리 퇴치 (D2)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = nextInt();  // 격자 크기
			int M = nextInt();  // 파리채 크기
			int[][] g = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					g[i][j] = nextInt();
				}
			}

			int max = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int current = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							current += g[i+k][j+l];
						}
					}
					if (current > max) {
						max = current;
					}
				}
			}
			append(String.format("#%s %s", tc + 1, max));
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

	private static <T> void append(T value) {
		sb.append(value).append("\n");
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
