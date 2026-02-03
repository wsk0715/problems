package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1954 {

	// 1954. 달팽이 숫자 (D2)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			// 방향 델타 - 우, 하, 좌, 상
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			int direction = 0;
			int r = 0;
			int c = 0;

			int[][] map = new int[N][N];
			for (int i = 1; i <= N * N; i++) {
				map[r][c] = i;

				int nr = r + dr[direction];
				int nc = c + dc[direction];

				if (!(0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == 0)) {
					direction = (direction + 1) % 4;
					nr = r + dr[direction];
					nc = c + dc[direction];
				}

				r = nr;
				c = nc;
			}

			append("#" + tc);
			for (int[] arr : map) {
				for (int i : arr) {
					sb.append(i).append(" ");
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

	private static <T> void append(T value) {
		sb.append(value).append("\n");
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
