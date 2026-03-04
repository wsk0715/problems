package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1974. 스도쿠 검증 (D2)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq
 */
public class Solution_1974_1 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			boolean[][] rows = new boolean[9][9];
			boolean[][] cols = new boolean[9][9];
			boolean[][] grids = new boolean[9][9];

			boolean flag = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					int idx = nextInt() - 1;

					int gi = (i / 3) * 3 + (j / 3);
					if (rows[i][idx] || cols[j][idx] || grids[gi][idx]) {
						flag = false;
					}

					rows[i][idx] = true;
					cols[j][idx] = true;
					grids[gi][idx] = true;
				}
			}

			sb.append(flag ? 1 : 0);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}


	// Libraries
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
