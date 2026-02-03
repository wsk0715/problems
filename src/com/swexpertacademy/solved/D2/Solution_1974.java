package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1974 {

	// 1974. 스도쿠 검증 (D2)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq
	public static void main(String[] args) throws IOException {
		int N = 9;
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = nextInt();
				}
			}

			boolean con = true;
			// 1. 행 확인
			for (int i = 0; i < N; i++) {
				Set<Integer> row = new HashSet<>();
				for (int j = 0; j < N; j++) {
					row.add(map[i][j]);
				}
				if (row.size() < N) {
					con = false;
					break;
				}
			}

			// 2. 열 확인
			for (int i = 0; i < N; i++) {
				Set<Integer> col = new HashSet<>();
				for (int j = 0; j < N; j++) {
					col.add(map[j][i]);
				}
				if (col.size() < N) {
					con = false;
					break;
				}
			}

			// 3. 격자 확인
			for (int i = 0; i < N; i += 3) {
				for (int j = 0; j < N; j += 3) {

					Set<Integer> grid = new HashSet<>();
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							grid.add(map[i + k][j + l]);
						}
					}
					if (grid.size() < 9) {
						con = false;
						break;
					}
				}
			}

			append("#" + tc + " " + (con ? 1 : 0));
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
