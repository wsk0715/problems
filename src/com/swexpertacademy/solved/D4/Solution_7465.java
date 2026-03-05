package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 7465. 창용 마을 무리의 개수 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
 */
public class Solution_7465 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// 문제 입력 & 변수 초기화
			int N = nextInt();
			int M = nextInt();

			ArrayList<Integer>[] graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				int u = nextInt();
				int v = nextInt();

				graph[u].add(v);
				graph[v].add(u);
			}

			// 풀이
			Deque<Integer> q = new ArrayDeque<>();
			boolean[] visited = new boolean[N + 1];

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				// 이미 확인한 노드면 pass
				if (visited[i]) {
					continue;
				}

				// 현재 노드를 큐에 추가
				q.offer(i);
				visited[i] = true;

				// 더 이상 인접 노드가 나오지 않을 때까지 BFS
				while (!q.isEmpty()) {
					int cur = q.poll();

					for (Integer next : graph[cur]) {
						// 이미 확인한 노드인지 체크
						if (!visited[next]) {
							q.offer(next);
							visited[next] = true;
						}
					}
				}
				// 전역 변수(큐) 초기화
				q.clear();

				// 무리 +1
				cnt += 1;
			}

			sb.append("#").append(tc).append(" ");
			sb.append(cnt);
			sb.append("\n");
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
