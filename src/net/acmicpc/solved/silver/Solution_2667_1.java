package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 단지번호붙이기 - S1
 * https://www.acmicpc.net/problem/2667
 */
public class Solution_2667_1 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int result;

	// 방향 벡터 - 상,하,좌,우
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		N = nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = chars[j] - '0';
			}
		}
		result = 0;

		// bfs가 아닌 dfs로 풀어보기(상태 누적)
		List<Integer> al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					al.add(calc(i, j));
					result += 1;
				}
			}
		}

		sb.append(result).append("\n");

		al.sort(Integer::compareTo);
		al.forEach(x -> sb.append(x).append("\n"));

		System.out.println(sb);
		br.close();
	}

	static int calc(int ci, int cj) {

		visited[ci][cj] = true;
		int cnt = 1;

		for (int k = 0; k < 4; k++) {
			int ni = ci + di[k];
			int nj = cj + dj[k];

			if (!(0 <= ni && ni < N && 0 <= nj && nj < N)) {
				continue;
			}
			if (map[ni][nj] == 0 || visited[ni][nj]) {
				continue;
			}

			cnt += calc(ni, nj);
		}

		return cnt;
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
