package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_12712 {

	// 12712. 파리퇴치3 (D2)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXuARWAqDkQDFARa
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int M = nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = nextInt();
				}
			}

			// 방향 1. 상-우-하-좌
			int[] di1 = {-1, 0, 1, 0};
			int[] dj1 = {0, 1, 0, -1};

			// 방향 2. 우상-우하-좌하-좌상
			int[] di2 = {-1, 1, 1, -1};
			int[] dj2 = {1, 1, -1, -1};

			int max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int current;

					// 현재 위치로부터 방향1 시뮬레이션
					current = map[i][j];
					for (int k = 0; k < 4; k++) { // 방향
						for (int l = 1; l < M; l++) {  // 거리
							int ni = i + di1[k] * l;
							int nj = j + dj1[k] * l;

							boolean con = 0 <= ni && ni < N && 0 <= nj && nj < N;
							if (!con) {
								// 격자를 벗어나면, 현재 방향 탐색 종료, 다음 방향 탐색
								break;
							}
							current += map[ni][nj];
						}
					}
					max = Math.max(current, max);

					// 현재 위치로부터 방향2 시뮬레이션
					current = map[i][j];
					for (int k = 0; k < 4; k++) { // 방향
						for (int l = 1; l < M; l++) {  // 거리
							int ni = i + di2[k] * l;
							int nj = j + dj2[k] * l;

							boolean con = 0 <= ni && ni < N && 0 <= nj && nj < N;
							if (!con) {
								// 격자를 벗어나면, 현재 방향 탐색 종료, 다음 방향 탐색
								break;
							}
							current += map[ni][nj];
						}
					}
					max = Math.max(current, max);
				}
			}


			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(max)
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
