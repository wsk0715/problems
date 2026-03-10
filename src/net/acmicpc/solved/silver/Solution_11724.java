package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 연결 요소의 개수 - S2
 * https://www.acmicpc.net/problem/11724
 */
public class Solution_11724 {

	static List<Integer>[] graph;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {

		// 입력 & 변수 초기화
		int N = nextInt(), M = nextInt();

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = nextInt();
			int v = nextInt();

			// 무방향 그래프 연결
			graph[u].add(v);
			graph[v].add(u);
		}

		visited = new boolean[N + 1];
		result = 0;

		// 풀이
		// 모든 노드를 한번씩 확인해야 하기 때문에 for문 사용
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			// 현재 노드를 이미 방문했으면 패스
			if (visited[i]) {
				continue;
			}

			// 현재 노드를 큐에 삽입, 방문 처리
			q.offer(i);
			visited[i] = true;

			// 모든 인접 노드 탐색
			while (!q.isEmpty()) {
				int cur = q.poll();

				// 현재 노드의 모든 인접 노드에 대해
				for (int next : graph[cur]) {

					// 아직 방문하지 않은 노드에 대해
					if (!visited[next]) {
						// 큐에 삽입, 방문 처리
						q.offer(next);
						visited[next] = true;
					}
				}
			}

			// 모든 인접 노드 탐색 후, 카운트 +1
			result += 1;
		}

		sb.append(result);
		System.out.print(sb);
		br.close();
	}


	// Libraries
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
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

}
