package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11315_1 {

	// 11315. 오목 판정 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = nextToken().toCharArray();
			}

			// 확인해야 하는 방향: 우, 우하, 하, 좌하
			int[] di = {1, 1, 0, -1};
			int[] dj = {0, 1, 1, 1};

			boolean omok = false;
			main:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j] != 'o') {
						continue;
					}

					// 각 방향 확인
					for (int k = 0; k < 4; k++) {
						// 탐색 거리: +4칸
						int count = 0;
						for (int l = 0; l < 5; l++) {
							int ni = i + di[k] * l;
							int nj = j + dj[k] * l;

							boolean con = -1 < ni && ni < N && -1 < nj && nj < N;
							if (con) {
								// 연속되지 않으면, 현재 방향 탐색 종료
								if (map[ni][nj] != 'o') {
									break;
								}
								count += 1;
							}
						}
						if (count == 5) {
							omok = true;
							break main;
						}
					}
				}
			}

			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(omok ? "YES" : "NO")
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

	private static <T> void append(T value) {
		sb.append(value).append("\n");
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
