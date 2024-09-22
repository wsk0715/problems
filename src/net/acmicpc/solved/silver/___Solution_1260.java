package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ___Solution_1260 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static List<Integer>[] graph;
	static int N, M, V;
	static List<Integer> dfs = new ArrayList<>();
	static List<Integer> bfs = new ArrayList<>();

	// DFS와 BFS - S2
	// https://www.acmicpc.net/problem/1260
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		N = input[0];  // 정점 vortex, 노드 node
		M = input[1];  // 간선 edge
		V = input[2];  // 시작 지점

		// 그래프 생성
		create();

		// 그래프 탐색 - DFS
		boolean[] visited = new boolean[N + 1];  // N번 노드까지, 각 노드 방문 여부
		dfs(V, visited);
		write(dfs.stream()
				 .map(String::valueOf)
				 .collect(Collectors.joining(" ")));

		// 그래프 탐색 - DFS
		bfs(V);
		write(bfs.stream()
				 .map(String::valueOf)
				 .collect(Collectors.joining(" ")));

		close();
	}

	private static void create() throws IOException {
		// 1. 그래프 생성(노드)
		graph = new ArrayList[N + 1];  // N번 노드까지 인덱스를 통해 접근
		for (int i = 1; i <= N; i++) {  // 1번 노드부터 시작
			graph[i] = new ArrayList<>();
		}

		// 2. 간선 정보 입력
		for (int i = 0; i < M; i++) {
			// 서로 연결된 노드 입력
			int[] in = readIntegers();
			int a = in[0];  // 노드 a
			int b = in[1];  // 노드 b

			// 양방향 간선 처리
			graph[a].add(b);  // a -> b
			graph[b].add(a);  // b -> a
		}

		// 3. (선택) 간선 오름차순 정렬 -> 작은것부터 방문하도록
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
	}

	public static void dfs(int V, boolean[] visited) {
		// 1. 현재 노드 방문 처리
		visited[V] = true;
		dfs.add(V);

		// 2. 깊이 우선 탐색 - 스택(재귀) 이용
		for (Integer node : graph[V]) {  // a. 현재 탐색 중인 노드 V와 연결된 노드에 대해
			if (!visited[node]) {  // b. 방문하지 않은 노드가 있다면
				dfs(node, visited);  // c. 해당 노드를 방문 -> '방문하지 않은 노드가 존재하지 않을 때까지' 재귀반복
			}
		}
	}

	public static void bfs(int V) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		// 1. 현재 노드 방문 처리, 큐에 삽입
		visited[V] = true;
		queue.add(V);

		// 2. 너비 우선 탐색 - 큐 이용
		while (!queue.isEmpty()) {
			int v = queue.poll();  // a. 큐에서 탐색 예정 노드를 꺼낸 후, 탐색
			bfs.add(v);

			// b. 현재 노드의 모든 인접 노드에 대해
			for (Integer node : graph[v]) {
				if (!visited[node]) {
					// c. 방문하지 않은 인접 노드를 탐색 예정 큐에 삽입 후, 방문 처리
					visited[node] = true;
					queue.add(node);
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
