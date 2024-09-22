package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class __Solution_11724 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static List<Integer>[] graph;
	static boolean[] visited;
	static int N, M;

	// 연결 요소의 개수 - S2
	// https://www.acmicpc.net/problem/11724
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		N = input[0];
		M = input[1];

		// 그래프 생성
		create();
		visited = new boolean[N + 1];

		// 그래프 탐색
		// 연결 요소? 서로 떨어져 있는 별개의 그래프(덩어리)의 개수
		// -> visited가 모두 boolean이 될 때까지 탐색해볼까?

		int r = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}
			// visited에서 true가 아닌 노드 찾아 탐색
			int V = 0;
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					V = j;
					break;
				}
			}
			bfs(V);
			r += 1;
		}
		write(r);

		close();
	}


	private static void create() throws IOException {
		// 그래프 생성
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 삽입
		for (int i = 0; i < M; i++) {
			int[] in = readIntegers();
			int a = in[0];
			int b = in[1];

			graph[a].add(b);
			graph[b].add(a);
		}
	}

	private static void bfs(int V) {
		Deque<Integer> deque = new ArrayDeque<>();

		// V 노드부터 삽입, 방문 처리
		deque.add(V);
		visited[V] = true;

		while (!deque.isEmpty()) {
			// 탐색 노드 방문 처리
			int v = deque.poll();
			visited[v] = true;

			for (Integer node : graph[v]) {
				if (!visited[node]) {
					deque.add(node);
					visited[node] = true;
				}
			}
		}
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine()
								  .trim());
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(br.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

	private static <T> void write(T value) throws IOException {
		String s = String.valueOf(value);
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

}
