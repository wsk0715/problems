package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 미로 탐색 - S1
 * https://www.acmicpc.net/problem/2178
 */
public class Solution_2178_fail {

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
			visited[i] = new boolean[M];
		}
		result = Integer.MAX_VALUE;

		// 시간 초과(TLE)로 실패 -> 가능한 모든 경우의 수(경로)를 뒤져야 하기 때문
		calc(0, 0, 1);  // 0,0에서부터 카운트

		sb.append(result);
		System.out.println(sb);
		br.close();
	}

	static void calc(int ci, int cj, int cnt) {
		if (map[ci][cj] != '1') {
			return;
		}

		if (ci == N - 1 && cj == M - 1) {
			result = Math.min(result, cnt);
		}

		visited[ci][cj] = true;
		for (int i = 0; i < 4; i++) {
			int ni = ci + di[i];
			int nj = cj + dj[i];

			if (!(0 <= ni && ni < N && 0 <= nj && nj < M)) {
				continue;
			}

			if (visited[ni][nj]) {
				continue;
			}

			calc(ni, nj, cnt + 1);
		}
		visited[ci][cj] = false;  // 백트래킹
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
