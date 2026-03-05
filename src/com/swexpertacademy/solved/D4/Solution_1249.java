package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 1249. 보급로 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&
 */
public class Solution_1249 {

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = nextInt();

			int[][] map = new int[N][N];
			int[][] costs = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] chars = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = chars[j] - '0';
				}
				Arrays.fill(costs[i], Integer.MAX_VALUE);
			}

			Deque<int[]> q = new ArrayDeque<>();  // [i, j, cost]
			q.offer(new int[]{0, 0, 0});
			costs[0][0] = 0;

			int min = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int ci = cur[0];
				int cj = cur[1];
				int cost = cur[2];

				// 종료 조건; 도착지 도달
				if (ci == N - 1 && cj == N - 1) {
					min = Math.min(min, cost);
				}

				// 시뮬레이션 로직
				for (int d = 0; d < 4; d++) {
					int ni = ci + di[d];
					int nj = cj + dj[d];

					if (0 <= ni && ni < N && 0 <= nj && nj < N) {
						int newCost = cost + map[ni][nj];

						// 기존 누적방문 비용보다 현재 비용이 더 싼 경우, 새롭게 탐색 수행
						if (newCost < costs[ni][nj]) {
							q.offer(new int[]{ni, nj, newCost});
							costs[ni][nj] = newCost;
						}
					}
				}
			}

			sb.append(min);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}


	// Libraries
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;

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

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
