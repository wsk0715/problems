package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 최단경로 - G4
 * https://www.acmicpc.net/problem/1753
 */
public class Solution_1753 {

	public static void main(String[] args) throws IOException {
		init();

		int V = nextInt();
		int E = nextInt();
		int K = nextInt();

		List<Node>[] graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int u = nextInt(), v = nextInt(), w = nextInt();

			Node n = new Node(v, w);

			graph[u].add(n);
		}

		// K 정점으로부터 각 정점으로의 최단경로
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] dists = new int[V + 1];
		Arrays.fill(dists, Integer.MAX_VALUE);

		q.offer(new Node(K, 0));  // 시작점 K로 이동하는 것으로 간주 & 비용 0
		dists[K] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.w > dists[cur.v]) continue;

			for (Node next : graph[cur.v]) {
				if (dists[next.v] > cur.w + next.w) {  // 기존 이동 비용이 현재 이동 비용보다 큰 경우, 갱신
					dists[next.v] = cur.w + next.w;
					q.offer(new Node(next.v, dists[next.v]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			sb.append(dists[i] == Integer.MAX_VALUE ? "INF" : dists[i]).append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static class Node implements Comparable<Node> {

		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

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
