package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1860_1 {

	// 1860. 진기의 최고급 붕어빵 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int M = nextInt();
			int K = nextInt();

			// PriorityQueue, time 기반으로 시뮬레이션 하는건 비효율적. 다른 방법으로 풀기 (그리디?)
			boolean result = true;

			PriorityQueue<Integer> q = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				q.offer(nextInt());
			}

			int soldBread = 0;
			while (!q.isEmpty()) {
				int visitTime = q.poll();  // 방문 시각
				int currentBread = (visitTime / M) * K - soldBread;

				// 현재 손님이 붕어빵 살 수 있는지 확인
				if (currentBread < 1) {
					result = false;
					break;
				}

				// 구매 가능한 경우
				soldBread += 1;
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
