package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3499_3 {

	// 3499. 퍼펙트 셔플 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			// ArrayDeque에서는 iterator로 유의미한 차이가 생기지 않음; LinkedList로 변경해서 비교
			Deque<String> d1 = new LinkedList<>();
			Deque<String> d2 = new LinkedList<>();

			for (int i = 0; i < (N + 1) / 2; i++) {
				d1.offer(nextToken());
			}
			for (int i = 0; i < N / 2; i++) {
				d2.offer(nextToken());
			}

			sb.append("#")
			  .append(tc);
			while (true) {
				if (!d1.isEmpty()) {
					sb.append(" ").append(d1.poll());
				}
				if (!d2.isEmpty()) {
					sb.append(" ").append(d2.poll());
				}
				if (d1.isEmpty() && d2.isEmpty()) {
					break;
				}
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
