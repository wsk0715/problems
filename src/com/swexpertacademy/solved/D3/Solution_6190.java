package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 6190. 정곤이의 단조 증가하는 수 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWcPjEuKAFgDFAU4
 */
public class Solution_6190 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = nextInt();
			}

			int max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int val = arr[i] * arr[j];

					if (!calc(val)) {
						continue;
					}

					max = Math.max(max, val);
				}
			}

			sb.append("#").append(tc).append(" ");
			sb.append(max);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static boolean calc(int val) {
		int prev = -1;
		for (char cur : String.valueOf(val).toCharArray()) {
			int v = cur - '0';
			if (v < prev) {
				return false;
			}
			prev = v;
		}

		return true;
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
