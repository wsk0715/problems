package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 9940. 순열1 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXHx23oq0REDFAXR
 */
public class Solution_9940 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = nextInt();
			boolean[] selected = new boolean[N + 1];

			boolean flag = true;
			for (int i = 0; i < N; i++) {
				int num = nextInt();

				if (selected[num]) {
					flag = false;
				}
				selected[num] = true;
			}

			sb.append("#").append(tc).append(" ");
			sb.append(flag ? "Yes" : "No");
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
