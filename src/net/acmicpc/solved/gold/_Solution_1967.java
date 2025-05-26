package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Solution_1967 {

	static int N;
	static Map<Integer, Node> hm = new HashMap<>();

	// 트리의 지름 - G4
	// https://www.acmicpc.net/problem/1967
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		N = nextInt();
		for (int i = 1; i < N; i++) {  // 간선 개수는 N-1개
			// 1-1. 노드 연결 입력
			int parent = nextInt();
			int child = nextInt();
			int cost = nextInt();

			// 2. 부모노드 삽입
			hm.putIfAbsent(parent, new Node(parent));
			Node parentNode = hm.get(parent);

			// 2-1. 자식노드 삽입
			hm.putIfAbsent(child, new Node(child));
			Node childNode = hm.get(child);

			// 2-2. 비용 설정 - 양방향
			parentNode.edges.add(new Edge(childNode, cost));
			childNode.edges.add(new Edge(parentNode, cost));
		}

		// 예외 처리
		if (N == 1) {
			write(0);
			close();
			return;
		}

		// 3. 탐색 시작
		// 3-1. 먼저, 임의의 노드에서 탐색을 시작해 가장 먼 노드 찾기
		Result firstResult = bfs(1);

		// 3-2. 해당 노드에서 다시 탐색 수행 -> 트리에서 가장 먼 거리(트리의 지름)
		Result result = bfs(firstResult.maxIdx);

		// 4. 결과 출력
		write(result.max);

		close();
	}

	static Result bfs(int start) {
		// 변수 설정
		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		int[] costs = new int[N + 1];  // 1-based index
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;

		// 탐색 시작
		Node startNode = hm.get(start);
		queue.add(startNode);
		visited[startNode.value] = true;

		while (!queue.isEmpty()) {
			// 큐에서 현재 노드 꺼내기
			Node currentNode = queue.poll();
			int current = currentNode.value;

			// 간선으로 연결된 각각의 노드에 대해 반복
			for (Edge e : currentNode.edges) {
				Node nextNode = e.destination;
				int next = nextNode.value;
				int cost = e.cost;

				if (!visited[next]) {
					// 탐색 수행
					costs[next] = costs[current] + cost;  // (다음 경로까지의 비용) = (현재 경로까지의 비용) + (다음 경로의 비용)
					visited[next] = true;
					queue.add(nextNode);

					// 최대 거리 계산
					if (costs[next] > max) {
						max = costs[next];
						maxIdx = next;
					}
				}
			}
		}
		return new Result(max, maxIdx);
	}

	static class Node {

		int value;
		List<Edge> edges = new ArrayList<>();

		public Node(int value) {
			this.value = value;
		}

	}

	static class Edge {

		Node destination;
		int cost;

		public Edge(Node destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}

	}

	static class Result {

		int max;
		int maxIdx;

		public Result(int max, int maxIdx) {
			this.max = max;
			this.maxIdx = maxIdx;
		}

	}


	// Libraries
	private static StringTokenizer readLine() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	private static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = readLine();
		}
		return Integer.parseInt(st.nextToken());
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

}
