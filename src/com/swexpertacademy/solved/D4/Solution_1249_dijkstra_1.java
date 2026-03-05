package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 1249. 보급로 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&
 */
public class Solution_1249_dijkstra_1 {

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = nextInt();

			int[][] map = new int[N][N];
			int[][] costs = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] chars = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = chars[j] - '0';
				}
				Arrays.fill(costs[i], Integer.MAX_VALUE);
			}

			// 람다식 전달 대신 Comparable 인터페이스를 구현한 상태(State) 클래스로 구현하기
			PriorityQueue<State> q = new PriorityQueue<>();  // [i, j, cost]
			q.offer(new State(0, 0, 0));
			costs[0][0] = 0;

			int min = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				State cur = q.poll();  // 우선순위 큐를 사용했기 때문에 현재까지 누적 비용이 가장 작은 상태가 큐에서 먼저 나온다. (그리디)
				int ci = cur.i;
				int cj = cur.j;
				int cost = cur.cost;

				// 가지치기; 이미 더 빠른 경로가 존재할 시
				if (cost > costs[ci][cj]) {
					continue;
				}

				// 종료 조건; 도착지 도달
				if (ci == N - 1 && cj == N - 1) {
					min = Math.min(min, cost);
					break;  // 다익스트라에서 가장 먼저 도착 == 가장 빠른 경로
				}

				// 시뮬레이션 로직
				for (int d = 0; d < 4; d++) {
					int ni = ci + di[d];
					int nj = cj + dj[d];

					if (0 <= ni && ni < N && 0 <= nj && nj < N) {
						int newCost = cost + map[ni][nj];

						// 기존 누적방문 비용보다 현재 비용이 더 싼 경우, 새롭게 탐색 수행
						if (newCost < costs[ni][nj]) {
							q.offer(new State(ni, nj, newCost));
							costs[ni][nj] = newCost;
						}
					}
				}
			}

			sb.append(min);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static class State implements Comparable<State> {

		int i;
		int j;
		int cost;

		State(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		@Override
		public int compareTo(State o) {
			return Integer.compare(this.cost, o.cost);
		}

	}


	// Libraries
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;

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

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
