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
public class Solution_2178 {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int result;

	// 방향 벡터 - 상,하,좌,우
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		N = nextInt();
		M = nextInt();
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().trim().toCharArray();
		}
		result = Integer.MAX_VALUE;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0, 0, 1});  // [i, j, cnt]
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int ci = current[0];
			int cj = current[1];
			int cnt = current[2];

			// 탐색 종료 조건; 미로 끝에 도달
			if (ci == N - 1 && cj == M - 1) {
				result = cnt;  // bfs - 가장 먼저 도착한 경로가 최단 경로(항상 같은 depth끼리 경쟁하기때문)
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ni = ci + di[i];
				int nj = cj + dj[i];

				if (!(0 <= ni && ni < N && 0 <= nj && nj < M)  // 경계조건 체크
					|| visited[ni][nj]                         // 방문여부 체크
					|| map[ni][nj] != '1'                      // 길인지 체크
				) {
					continue;
				}

				q.offer(new int[]{ni, nj, cnt + 1});
				visited[ni][nj] = true;
			}
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
