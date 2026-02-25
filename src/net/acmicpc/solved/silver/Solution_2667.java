package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 단지번호붙이기 - S1
 * https://www.acmicpc.net/problem/2667
 */
public class Solution_2667 {


	public static void main(String[] args) throws IOException {
		// 방향 벡터 - 상,하,좌,우
		int[] di = {-1, 1, 0, 0};
		int[] dj = {0, 0, -1, 1};

		int N = nextInt();
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = chars[j] - '0';
			}
		}
		int result = 0;

		// 1. 진입점(i, j)
		// 2. 인접 요소 값이 1인 경우 계속 탐색
		// 3. 더이상 인접한 1이 없을때까지(depth) 반복 & 단지 수 +1
		List<Integer> al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					// 인접한 모든 블럭 탐색
					Queue<int[]> q = new LinkedList<>();

					q.offer(new int[]{i, j});
					int cnt = 1;
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
							if (map[ni][nj] == 0 || visited[ni][nj]) {
								continue;
							}

							q.offer(new int[]{ni, nj});
							cnt += 1;
							visited[ni][nj] = true;
						}
					}

					al.add(cnt);
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
