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
 * 파티 - G3
 * https://www.acmicpc.net/problem/1238
 */
public class Solution_1238 {

	static List<Node>[] graph;
	static PriorityQueue<Node> q;
	static int[] dist;
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		init();

		N = nextInt();
		M = nextInt();
		X = nextInt();

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = nextInt(), v = nextInt(), w = nextInt();

			graph[u].add(new Node(v, w));
		}

		q = new PriorityQueue<>();
		dist = new int[N + 1];

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			int cost = 0;

			cost += dijkstra(i, X);
			cost += dijkstra(X, i);

			max = Math.max(max, cost);
		}

		sb.append(max);
		System.out.print(sb);
		br.close();
	}

	static int dijkstra(int from, int to) {
		int cost = 0;

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[from] = 0;
		q.offer(new Node(from, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.w > dist[cur.v]) continue;

			if (cur.v == to) {
				cost += cur.w;
				break;
			}

			for (Node next : graph[cur.v]) {
				if (dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					q.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		q.clear();

		return cost;
	}

	static class Node implements Comparable<Node> {

		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

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

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
