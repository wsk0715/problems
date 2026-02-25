package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 특정 거리의 도시 찾기 - S2
 * https://www.acmicpc.net/problem/18352
 */
public class __Solution_18352 {

	public static void main(String[] args) throws IOException {

		int N = nextInt();  // 도시 수
		int M = nextInt();  // 도로 개수
		int K = nextInt();  // 목표 거리
		int X = nextInt();  // 출발 도시 번호

		// 인접 리스트 그래프
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 가중치가 1인 경로 탐색 문제?
		for (int i = 0; i < M; i++) {
			int from = nextInt();
			int to = nextInt();

			graph[from].add(to);
		}

		Deque<Integer> q = new ArrayDeque<>();  // [i, dist]

		q.offer(X);

		int[] dists = new int[N + 1];
		Arrays.fill(dists, -1);
		dists[X] = 0;

		while (!q.isEmpty()) {
			int current = q.poll();

			if (dists[current] > K) {
				break;
			}

			for (int next : graph[current]) {
				if (dists[next] == -1) {
					q.offer(next);
					dists[next] = dists[current] + 1;
				}
			}
		}

		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (dists[i] == K) {
				sb.append(i).append("\n");
				flag = true;
			}
		}

		System.out.println(flag ? sb : -1);
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
