package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 10726. 이진수 표현 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXRSXf_a9qsDFAXS
 */
public class Solution_10726_1 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int M = nextInt();

			// 비트를 활용한 풀이
			int[] bits = new int[31];  // 부호 비트 무시
			int l = bits.length - 1;
			for (int i = 0; M > 0; i++) {
				int idx = l - i;

				bits[idx] = M % 2;
				M /= 2;
			}

			boolean flag = true;
			for (int i = 0; i < N; i++) {
				int idx = l - i;

				if (bits[idx] == 0) {
					flag = false;
					break;
				}
			}

			sb.append("#").append(tc).append(" ");
			sb.append(flag ? "ON" : "OFF");
			sb.append("\n");
		}

		System.out.println(sb);
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
