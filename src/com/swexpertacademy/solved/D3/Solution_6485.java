package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6485 {

	// 6485. 삼성시의 버스 노선 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWczm7QaACgDFAWn
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int[] a = new int[N];
			int[] b = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = nextInt();
				b[i] = nextInt();
			}
			int P = nextInt();
			int[] c = new int[P];
			for (int i = 0; i < P; i++) {
				c[i] = nextInt();
			}

			// 완전 탐색으로 풀어보기
			int[] lines = new int[P];
			for (int i = 0; i < P; i++) {
				for (int j = 0; j < N; j++) {
					if (a[j] <= c[i] && c[i] <= b[j]) {
						lines[i] += 1;
					}
				}
			}

			StringBuilder result = new StringBuilder();
			for (int i : lines) {
				result.append(i).append(" ");
			}

			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(result)
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
