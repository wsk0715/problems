package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 4613. 러시아 국기 같은 깃발 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQl9TIK8qoDFAXj
 */
public class Solution_4613 {

	static char[] colors = {'W', 'B', 'R'};

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = nextInt(), M = nextInt();
			char[][] map = new char[N][M];
			int[][] colors = new int[N][3];  // [W, B, R]

			for (int i = 0; i < N; i++) {
				char[] chars = br.readLine().trim().toCharArray();
				for (int j = 0; j < M; j++) {
					char c = chars[j];
					map[i][j] = c;

					switch (c) {
						case 'W':
							colors[i][0] += 1;
							break;
						case 'B':
							colors[i][1] += 1;
							break;
						case 'R':
							colors[i][2] += 1;
							break;
					}
				}
			}

			Deque<State> q = new ArrayDeque<>();  // [i, prev, current]
			// 첫줄 - 무조건 하양, 막줄 - 무조건 빨강
			int cost = M - colors[0][0] + M - colors[N - 1][2];
			q.offer(new State(1, 'W', cost, false));
			q.offer(new State(1, 'B', cost, false));

			int min = Integer.MAX_VALUE;
			while (!q.isEmpty()) {
				State cur = q.poll();

				if (cur.row == N - 1) {
					if (!cur.usedBlue) {
						continue;
					}
					min = Math.min(min, cur.cost);
					continue;
				}

				if (cur.color == 'W') {
					q.offer(new State(cur.row + 1, 'W', cur.cost + M - colors[cur.row][0], cur.usedBlue));
					q.offer(new State(cur.row + 1, 'B', cur.cost + M - colors[cur.row][1], true));
				} else if (cur.color == 'B') {
					q.offer(new State(cur.row + 1, 'B', cur.cost + M - colors[cur.row][1], true));
					q.offer(new State(cur.row + 1, 'R', cur.cost + M - colors[cur.row][2], cur.usedBlue));
				} else if (cur.color == 'R') {
					q.offer(new State(cur.row + 1, 'R', cur.cost + M - colors[cur.row][2], cur.usedBlue));
				}
			}

			sb.append(min);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static class State {

		int row;
		char color;
		int cost;
		boolean usedBlue;

		State(int row, char color, int cost, boolean usedBlue) {
			this.row = row;
			this.color = color;
			this.cost = cost;
			this.usedBlue = usedBlue;
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
