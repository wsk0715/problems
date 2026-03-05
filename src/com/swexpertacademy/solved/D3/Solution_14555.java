package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 14555. 공과 잡초 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AYGtoa3qARcDFARC
 */
public class Solution_14555 {

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			char[] chars = br.readLine().trim().toCharArray();

			int cnt = 0;
			char prev = '\u0000';
			for (char c : chars) {
				if (c == '(') {
					cnt += 1;
				} else if (c == ')' && prev != '(') {
					cnt += 1;
				}
				prev = c;
			}

			sb.append(cnt);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}


	// Libraries
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

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

}
