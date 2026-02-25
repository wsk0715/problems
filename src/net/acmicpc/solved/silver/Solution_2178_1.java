package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 미로 탐색 - S1
 * https://www.acmicpc.net/problem/2178
 */
public class Solution_2178_1 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int result;

	// 방향 벡터 - 상,하,좌,우
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		N = nextInt();
		M = nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = chars[j] - '0';
			}
		}
		result = Integer.MAX_VALUE;

		// depth를 따로 전달하지 않고, bfs의 성질을 이용해 map[i][j]에 최단 시간 저장하기
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0, 0});  // [i, j]
		map[0][0] = 1;
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int ci = current[0];
			int cj = current[1];

			// 탐색 종료 조건; 미로 끝에 도달
			if (ci == N - 1 && cj == M - 1) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ni = ci + di[i];
				int nj = cj + dj[i];

				if (!(0 <= ni && ni < N && 0 <= nj && nj < M)
					|| visited[ni][nj]
					|| map[ni][nj] != 1
				) {
					continue;
				}

				q.offer(new int[]{ni, nj});
				map[ni][nj] = map[ci][cj] + 1;
				visited[ni][nj] = true;
			}
		}

		sb.append(map[N - 1][M - 1]);
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
