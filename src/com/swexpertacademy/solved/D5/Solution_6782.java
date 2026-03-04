package com.swexpertacademy.solved.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 6782. 현주가 좋아하는 제곱근 놀이 (D5)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgqsAlKr9sDFAW0
 */
public class Solution_6782 {

	public static void main(String[] args) throws IOException {
		long T = nextLong();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			long N = nextLong();

			long cnt = 0;
			while (N != 2) {
				double val = Math.sqrt(N);

				// 이미 제곱수라면, 제곱근 취하기
				if (val % 1 == 0) {
					N = (long) val;
					cnt += 1;
					continue;
				}

				// 가장 가까운 제곱수 찾기
				long closest = (long) Math.pow(Math.ceil(val), 2);
				long sub = closest - N;

				// 값 차이만큼 더하기
				N += sub;
				cnt += sub;
			}

			sb.append(cnt);
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

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
