package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 5789. 현주의 상자 바꾸기 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWYygN36Qn8DFAVm
 */
public class Solution_5789 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = nextInt(), Q = nextInt();

			int[] arr = new int[N];
			for (int i = 1; i <= Q; i++) {
				int l = nextInt() - 1, r = nextInt() - 1;

				for (int j = l; j <= r; j++) {
					arr[j] = i;
				}
			}

			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
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
