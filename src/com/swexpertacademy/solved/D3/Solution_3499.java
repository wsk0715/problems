package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3499 {

	// 3499. 퍼펙트 셔플 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			String[] arr = new String[N];
			for (int i = 0; i < N; i += 2) {
				arr[i] = nextToken();
			}
			for (int i = 1; i < N; i += 2) {
				arr[i] = nextToken();
			}

			sb.append("#").append(tc);
			for (String s : arr) {
				sb.append(" ").append(s);
			}
			sb.append("\n");
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
