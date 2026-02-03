package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {

	// 1210. Ladder1 (D4)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
	public static void main(String[] args) throws IOException {
		int N = 100;
		int T = 10;
		for (int tc = 0; tc < T; tc++) {
			int tc_number = nextInt();
			int[][] g = new int[N][N];
			int targetCol = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = nextInt();
					g[i][j] = n;

					if (n == 2) {
						targetCol = j;
					}
				}
			}

			int currentCol = targetCol;
			int currentRow = N - 1;
			while (currentRow != 0) {
				if (currentCol - 1 >= 0 && g[currentRow][currentCol - 1] == 1) {
					while (currentCol - 1 >= 0 && g[currentRow][currentCol - 1] == 1) {
						currentCol -= 1;
					}
				} else if (currentCol + 1 < N && g[currentRow][currentCol + 1] == 1) {
					while (currentCol + 1 < N && g[currentRow][currentCol + 1] == 1) {
						currentCol += 1;
					}
				}

				currentRow -= 1;
			}
			append(String.format("#%s %s", tc_number, currentCol));
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
