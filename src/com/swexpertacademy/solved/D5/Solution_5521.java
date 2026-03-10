package com.swexpertacademy.solved.D5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 5521. 상원이의 생일파티 (D5)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWWO3kT6F2oDFAV4
 */
public class Solution_5521 {

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = nextInt(), M = nextInt();
			List<Integer>[] graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				int u = nextInt();
				int v = nextInt();

				graph[u].add(v);
				graph[v].add(u);
			}

			Deque<int[]> q = new ArrayDeque<>();  // [adj, depth]
			boolean[] visited = new boolean[N + 1];

			q.offer(new int[]{1, 0});  // 상원이 = 1
			visited[1] = true;

			int result = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int node = cur[0];
				int depth = cur[1];

				if (depth == 2) {
					continue;
				}

				for (int adj : graph[node]) {
					if (!visited[adj]) {
						q.offer(new int[]{adj, depth + 1});
						visited[adj] = true;
						result += 1;
					}
				}
			}

			sb.append(result);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static void calc() {

	}


	// Libraries
	static BufferedReader br;
	static StringBuilder sb;
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

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
