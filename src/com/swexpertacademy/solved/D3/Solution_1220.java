package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1220 {

	// 1220. Magnetic (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD
	public static void main(String[] args) throws IOException {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = nextInt();
				}
			}

			Deque<Integer> dq = new ArrayDeque<>();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 2) {
						if (!dq.isEmpty()) {
							dq.pop();
							cnt += 1;
						}
					} else if (map[j][i] == 1) {
						if (dq.isEmpty()) {
							dq.push(1);
						}
					}
				}
				dq.clear();
			}

			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(cnt)
			  .append("\n");
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
