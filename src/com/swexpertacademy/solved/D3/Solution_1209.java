package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1209 {

	// 1209. Sum (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh
	public static void main(String[] args) throws IOException {
		int N = 100;
		for (int tc = 0; tc < 10; tc++) {
			int tc_number = nextInt();
			int[] sumRow = new int[N];
			int[] sumCol = new int[N];
			int[] sumCross = new int[2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = nextInt();

					sumRow[i] += n;
					sumCol[j] += n;

					if (i == j) {
						sumCross[0] += n;
					}
					if (i + j == N - 1) {
						sumCross[1] += n;
					}
				}
			}

			int maxRow = 0;
			for (int i : sumRow) {
				if (i > maxRow) {
					maxRow = i;
				}
			}
			int maxCol = 0;
			for (int i : sumCol) {
				if (i > maxCol) {
					maxCol =i;
				}
			}
			int maxCross = Math.max(sumCross[0], sumCross[1]);
			int result = Math.max(maxCross, Math.max(maxRow, maxCol));
			append("#" + tc_number + " " + result);
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
