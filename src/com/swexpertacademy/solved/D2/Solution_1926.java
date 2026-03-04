package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1926. 간단한 369게임 (D2)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PTeo6AHUDFAUq
 */
public class Solution_1926 {

	public static void main(String[] args) throws IOException {
		int T = 1;
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			for (int i = 1; i <= N; i++) {
				int n = i;

				// 각 자릿수 확인
				StringBuilder tmp = new StringBuilder();
				while (n > 0) {
					int val = n % 10;

					if (val != 0 && val % 3 == 0) {
						tmp.append("-");
					}

					n /= 10;
				}

				if (tmp.length() == 0) {
					sb.append(i).append(" ");
				} else {
					sb.append(tmp).append(" ");
				}
			}
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
