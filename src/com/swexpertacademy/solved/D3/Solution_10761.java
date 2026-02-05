package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_10761 {

	// 10761. 신뢰 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXSVc1TqEAYDFAQT
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			Deque<Integer> blue = new ArrayDeque<>();
			Deque<Integer> orange = new ArrayDeque<>();
			Deque<Character> order = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				if (nextToken().equals("B")) {
					blue.offer(nextInt());
					order.offer('B');
				} else {
					orange.offer(nextInt());
					order.offer('O');
				}
			}

			int posB = 1;
			int posO = 1;
			int time = 0;
			while (!order.isEmpty()) {
				char o = order.poll();
				Integer targetB = blue.peek();
				Integer targetO = orange.peek();

				if (o == 'B') {
					int dist = Math.abs(targetB - posB) + 1;
					posB = targetB;
					if (targetO != null) {
						if (posO < targetO) {
							posO = Math.min(posO + dist, targetO);
						} else if (posO > targetO) {
							posO = Math.max(posO - dist, targetO);
						}
					}
					blue.poll();
					time += dist;
				} else if (o == 'O') {
					int dist = Math.abs(targetO - posO) + 1;
					posO = targetO;
					if (targetB != null) {
						if (posB < targetB) {
							posB = Math.min(posB + dist, targetB);
						} else if (posB > targetB) {
							posB = Math.max(posB - dist, targetB);
						}
					}
					orange.poll();
					time += dist;
				}
			}


			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(time)
			  .append("\n");
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
