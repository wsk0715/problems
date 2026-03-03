package com.swexpertacademy.solved.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1247. 최적 경로 (D5)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
 */
public class Solution_1247 {

	static int N;
	static int[] company;
	static int[] home;
	static int[][] customers;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// 입력 받기
			N = nextInt();

			company = new int[]{nextInt(), nextInt()};

			home = new int[]{nextInt(), nextInt()};

			customers = new int[N][];
			for (int i = 0; i < N; i++) {
				customers[i] = new int[]{nextInt(), nextInt()};
			}

			visited = new boolean[N];

			result = Integer.MAX_VALUE;

			// 풀이
			calc(company[0], company[1], 0, 0);

			sb.append("#").append(tc).append(" ");
			sb.append(result);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static void calc(int ci, int cj, int depth, int sum) {
		// 가지치기
		if (sum >= result) return;

		// 탐색 종료 조건
		if (depth == N) {
			// 전부 방문 했으면 집으로 돌아가 & 최단 거리 갱신
			int dist = Math.abs(ci - home[0]) + Math.abs(cj - home[1]);
			result = Math.min(result, sum + dist);
			return;
		}

		// 백트래킹을 이용해 순열 선택
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int dist = Math.abs(customers[i][0] - ci) + Math.abs(customers[i][1] - cj);
				calc(customers[i][0], customers[i][1], depth + 1, sum + dist);
				visited[i] = false;
			}
		}
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
