package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 4193. 수영대회 결승전
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWKaG6_6AGQDFARV
 */
public class Solution_4193 {

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = nextInt();

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = nextInt();
				}
			}

			int A = nextInt(), B = nextInt();  // 시작위치
			int C = nextInt(), D = nextInt();  // 도착위치

			PriorityQueue<State> q = new PriorityQueue<>();
			int[][] dists = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dists[i], Integer.MAX_VALUE);
			}

			q.offer(new State(A, B, 0));
			dists[A][B] = 0;

			int min = Integer.MAX_VALUE;
			boolean flag = false;
			while (!q.isEmpty() && !flag) {
				State cur = q.poll();

				// 이전에 더 낮은 비용으로 방문한 경우
				if (cur.cost > dists[cur.i][cur.j]) {
					continue;
				}

				// 종료 조건; 목적지 도달 시
				if (cur.i == C && cur.j == D) {
					min = Math.min(min, cur.cost);
					flag = true;
				}

				// 탐색 수행
				for (int dir = 0; dir < 4; dir++) {
					int ni = cur.i + di[dir];
					int nj = cur.j + dj[dir];

					if (0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] != 1) {
						int estimated;

						// 소용돌이인 경우 처리
						if (map[ni][nj] == 2) {
							// 소용돌이는 0초에 생성, 1초 유지, 2초에 지나갈 수 있음, 반복(2, 5, 8..)
							int wait = (2 - (cur.cost % 3));
							estimated = cur.cost + wait + 1;
						} else {
							estimated = cur.cost + 1;
						}

						// 기존 이동 비용보다 적은 경우에만 삽입
						if (estimated < dists[ni][nj]) {
							dists[ni][nj] = estimated;
							q.offer(new State(ni, nj, estimated));
						}
					}
				}
			}

			sb.append(flag ? min : -1);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static class State implements Comparable<State> {

		int i;
		int j;
		int cost;

		public State(int i, int j, int cost) {
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
