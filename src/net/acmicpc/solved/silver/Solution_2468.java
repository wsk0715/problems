package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 안전 영역 - S1
 * https://www.acmicpc.net/problem/2468
 */
public class Solution_2468 {

	static int N;
	static int[][] map;

	// 방향 벡터 - 상,하,좌,우
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		N = nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = nextInt();
			}
		}

		// 영역의 최대 개수 ?
		// 인접한 타일이 적게 되는 경우? 비가 많이 올 때?
		// N이 작고(100) 최대 높이도 높지 않음(100) -> 일단 완탐?
		int result = -1;
		for (int height = 1; height <= 100; height++) {

			boolean[][] visited = new boolean[N][N];

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > height) {
						Queue<int[]> q = new LinkedList<>();  // [i, j]

						q.offer(new int[]{i, j});
						visited[i][j] = true;

						while (!q.isEmpty()) {
							int[] current = q.poll();
							int ci = current[0];
							int cj = current[1];

							for (int k = 0; k < 4; k++) {
								int ni = ci + di[k];
								int nj = cj + dj[k];

								if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) {
									continue;
								}
								if (visited[ni][nj] || map[ni][nj] <= height) {
									continue;
								}

								q.offer(new int[]{ni, nj});
								visited[ni][nj] = true;
							}
						}
						cnt += 1;
					}
				}
			}

			result = Math.max(result, cnt);
		}

		sb.append(result);

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
