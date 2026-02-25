package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 안전 영역 - S1
 * https://www.acmicpc.net/problem/2468
 */

public class Solution_2468_1 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int height;

	// 방향 벡터 - 상,하,좌,우
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		// 완탐 최적화하기
		// 1. 0부터 100까지의 높이를 모두 탐색하지 않고 주어진 입력을 바탕으로 범위 설정
		// -> 테스트 해보니 별 차이 없음(184ms vs 188ms)
		N = nextInt();
		map = new int[N][N];
		int min = 101;
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cur = nextInt();

				map[i][j] = cur;

				if (cur < min) {
					min = cur;
				}
				if (cur > max) {
					max = cur;
				}
			}
		}

		// 2. 객체 생성 오버헤드 최소화 - bfs -> dfs; N이 크지 않으니 재귀를 사용해도 ㄱㅊ
		int result = 1;
		for (int h = min; h <= max; h++) {

			visited = new boolean[N][N];
			height = h;

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						calc(i, j);
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

	static void calc(int ci, int cj) {

		visited[ci][cj] = true;

		for (int k = 0; k < 4; k++) {
			int ni = ci + di[k];
			int nj = cj + dj[k];

			if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) {
				continue;
			}
			if (visited[ni][nj] || map[ni][nj] <= height) {
				continue;
			}

			calc(ni, nj);
			visited[ni][nj] = true;
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
