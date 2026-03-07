package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1486. 장훈이의 높은 선반 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw
 */
public class Solution_1486 {

	static int N, B;
	static int min;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = nextInt();
			B = nextInt();
			min = Integer.MAX_VALUE;

			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = nextInt();
			}

			calc(0, 0);

			sb.append(min - B);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static void calc(int idx, int sum) {
		if (sum >= B) {
			min = Math.min(min, sum);
			return;
		}

		if (idx == N) {
			return;
		}

		// 현재 인덱스를 선택하는 경우
		calc(idx + 1, sum + arr[idx]);
		// 현재 인덱스를 선택하지 않는 경우
		calc(idx + 1, sum);
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
