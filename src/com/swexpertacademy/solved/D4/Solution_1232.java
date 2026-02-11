package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1232. 사칙연산 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141J8KAIcCFAYD
 */
public class Solution_1232 {

	static int N;
	static String[] values;
	static int[] lefts;
	static int[] rights;

	public static void main(String[] args) throws IOException {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			N = nextInt();
			values = new String[N + 1];
			lefts = new int[N + 1];
			rights = new int[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());

				// 인덱스 입력
				int idx = nextInt();

				// value 입력
				String current = nextToken();
				values[idx] = current;

				// 자식 노드가 있는 경우, 인덱스 저장
				if (st.hasMoreTokens()) {
					lefts[idx] = nextInt();
					rights[idx] = nextInt();
				}
			}

			sb.append("#").append(tc).append(" ");
			sb.append((int) calc(1));
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static double calc(int idx) {
		String val = values[idx];

		if (val.equals("+")) {
			return calc(lefts[idx]) + calc(rights[idx]);
		}
		if (val.equals("-")) {
			return calc(lefts[idx]) - calc(rights[idx]);
		}
		if (val.equals("*")) {
			return calc(lefts[idx]) * calc(rights[idx]);
		}
		if (val.equals("/")) {
			return calc(lefts[idx]) / calc(rights[idx]);
		}

		return Double.parseDouble(val);
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
