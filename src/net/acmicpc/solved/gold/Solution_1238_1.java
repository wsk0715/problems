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
public class Solution_1238_1 {

	static int N, M, X;

	static List<Node>[] graph, revGraph;
	static int[] dist, revDist;

	static PriorityQueue<Node> q;

	public static void main(String[] args) throws IOException {
		init();

		N = nextInt();
		M = nextInt();
		X = nextInt();

		// (2N) 시간 복잡도를 (2)로 최적화
		// 다익스트라를 N회 돌려야 했던 이유 = dist 배열이 각 시작점을 기준으로 하기 때문
		// 시작점이 아닌 도착점을 기준으로 하는 역방향 그래프를 별도로 만들어 다익스트라 횟수를 1회로 줄이기

		graph = new ArrayList[N + 1];
		revGraph = new ArrayList[N + 1];  // 반대방향 그래프
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			revGraph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = nextInt(), v = nextInt(), w = nextInt();

			graph[u].add(new Node(v, w));
			revGraph[v].add(new Node(u, w));
		}

		q = new PriorityQueue<>();
		dist = new int[N + 1];
		revDist = new int[N + 1];

		dijkstra(graph, dist);
		dijkstra(revGraph, revDist);

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int cur = dist[i] + revDist[i];

			max = Math.max(max, cur);
		}

		sb.append(max);
		System.out.print(sb);
		br.close();
	}

	static void dijkstra(List<Node>[] graph, int[] dist) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		q.offer(new Node(X, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.w > dist[cur.v]) continue;

			// 종료조건 없음; X로부터 출발하여 모든 방문 가능한 노드를 방문하도록

			for (Node next : graph[cur.v]) {
				if (dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					q.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		q.clear();
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
