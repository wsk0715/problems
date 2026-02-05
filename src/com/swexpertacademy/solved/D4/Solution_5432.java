package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 5432. 쇠막대기 자르기 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm
 */
public class Solution_5432 {

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			char[] chars = br.readLine().trim().toCharArray();

			int level = 0;
			int cnt = 0;

			char prev = '\u0000';
			for (char c : chars) {
				if (prev == '(' && c == ')') {
					level -= 1;
					cnt += level;
				} else if (c == '(') {
					level += 1;
				} else if (prev == ')' && c == ')') {
					level -= 1;
					cnt += 1;
				} else if (c == ')') {
					level -= 1;
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

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
