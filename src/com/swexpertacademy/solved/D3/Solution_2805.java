package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2805. 농작물 수확하기 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
 */
public class Solution_2805 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			int result = 0;
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().trim().toCharArray();
				for (int j = 0; j < line.length; j++) {
					int v = line[j] - '0';

					// 중심으로부터 특정 마름모 거리 안에 있는가? (Manhattan Distance)
					int dist = Math.abs(N / 2 - i) + Math.abs(N / 2 - j);

					// 범위에 속하면, 결과 갱신
					if (dist <= N / 2) {
						result += v;
					}
				}
			}

			sb.append("#").append(tc).append(" ");
			sb.append(result);
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
