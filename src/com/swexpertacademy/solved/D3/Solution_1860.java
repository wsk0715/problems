package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1860 {

	// 1860. 진기의 최고급 붕어빵 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int M = nextInt();
			int K = nextInt();

			PriorityQueue<Integer> q = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				q.offer(nextInt());
			}

			boolean result = true;
			int lastBreadTime = 0;
			int bread = 0;
			int time = 0;
			while (!q.isEmpty()) {
				// 마지막으로 붕어빵을 만든 지 M초가 지났다면
				if (time - lastBreadTime == M) {
					bread += K;  // K개만큼 추가
					lastBreadTime = time;
				}

				// 현재 방문한 손님이 붕어빵을 살 수 있는지 확인
				int visitTime = q.peek();
				if (time >= visitTime) {

					// 구매 불가능한 경우
					if (bread < 1) {
						result = false;
						break;
					}

					// 구매 가능한 경우
					bread -= 1;
					q.poll();
				}

				time += 1;
			}

			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(result ? "Possible" : "Impossible")
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

	private static <T> void append(T value) {
		sb.append(value).append("\n");
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
