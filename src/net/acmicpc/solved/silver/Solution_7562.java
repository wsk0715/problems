package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 나이트의 이동 - S1
 * https://www.acmicpc.net/problem/7562
 */
public class Solution_7562 {

	static int T;
	static int L;
	static int[][] map;

	// 방향 벡터 - 상좌, 상우, 하좌, 하우, 좌상, 좌하, 우상, 우하
	static int[] di = {-2, -2, 2, 2, -1, 1, -1, 1};
	static int[] dj = {-1, 1, -1, 1, -2, -2, 2, 2};

	public static void main(String[] args) throws IOException {

		T = nextInt();

		for (int tc = 0; tc < T; tc++) {

			L = nextInt();
			map = new int[L][L];

			// 현재 위치
			int si = nextInt();
			int sj = nextInt();

			// 목표 위치
			int ti = nextInt();
			int tj = nextInt();

			int result = 0;

			// 최소 이동 횟수(최단거리) -> BFS
			boolean[][] visited = new boolean[L][L];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[]{si, sj, 0});
			visited[si][sj] = true;

			while (!q.isEmpty()) {
				int[] current = q.poll();
				int ci = current[0];
				int cj = current[1];
				int moves = current[2];

				if (ci == ti && cj == tj) {
					result = moves;
					break;
				}

				for (int i = 0; i < 8; i++) {
					int ni = ci + di[i];
					int nj = cj + dj[i];

					if (!(0 <= ni && ni < L && 0 <= nj && nj < L)) {
						continue;
					}
					if (visited[ni][nj]) {
						continue;
					}

					q.offer(new int[]{ni, nj, moves + 1});
					visited[ni][nj] = true;
				}
			}

			sb.append(result).append("\n");
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
