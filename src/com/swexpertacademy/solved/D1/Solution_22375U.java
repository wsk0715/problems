package com.swexpertacademy.solved.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 22375. 스위치 조작 (D1)
 * https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZHA7Cn6ZgsDFAQP
 */
public class Solution_22375U {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = nextInt();
			int[] from = new int[N];
			for (int i = 0; i < N; i++) {
				from[i] = nextInt();
			}

			int[] to = new int[N];
			for (int i = 0; i < N; i++) {
				to[i] = nextInt();
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (from[i] != to[i]) {
					for (int j = i; j < N; j++) {
						from[j] = from[j] == 1 ? 0 : 1;
					}
					cnt += 1;
				}
			}


			sb.append("#").append(tc).append(" ");
			sb.append(cnt);
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
