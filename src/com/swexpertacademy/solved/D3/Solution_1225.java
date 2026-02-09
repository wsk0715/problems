package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1225 {

	// 1225. 암호 생성기 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
	public static void main(String[] args) throws IOException {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			nextInt();

			Deque<Integer> dq = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				dq.offer(nextInt());
			}

			while (true) {
				int current;

				boolean flag = false;
				for (int i = 1; i <= 5; i++) {
					current = dq.poll();

					if (current <= i) {
						dq.offer(0);
						flag = true;
						break;
					}

					dq.offer(current - i);
				}

				if (flag) {
					break;
				}
			}

			sb.append("#").append(tc);
			while (!dq.isEmpty()) {
				sb.append(" ").append(dq.poll());
			}
			sb.append("\n");
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
