package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ___Solution_11725 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 트리의 부모 찾기 - S2
	// https://www.acmicpc.net/problem/11725
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 간선(edge) 정보를 저장할 리스트 생성
		List<List<Integer>> al = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			al.add(new ArrayList<>());
		}

		// 간선 정보 입력받아 저장
		for (int i = 0; i < n - 1; i++) {
			int[] edge = readIntegers();
			int u = edge[0];
			int v = edge[1];

			// 양방향 간선
			al.get(u).add(v);
			al.get(v).add(u);
		}

		// 큐를 이용한 그래프 탐색(BFS)
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];  // 방문 여부
		int[] parent = new int[n + 1];  // 각 노드의 부모를 저장할 배열

		// 1번 노드(루트; 최상위 노드)부터 BFS 시작
		queue.offer(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : al.get(current)) {  // 현재 노드와 연결된 모든 노드에 대해
				if (!visited[next]) {  // 해당 노드를 방문하지 않았다면
					parent[next] = current;  // 해당 노드의 부모를 현재 노드로 설정
					visited[next] = true;  // 방문 처리
					queue.offer(next);  // 다음 탐색을 위해 큐에 삽입
				}
			}
		}

		// 2번 노드부터 n번 노드까지의 부모 노드 출력
		for (int i = 2; i <= n; i++) {
			write(parent[i]);
		}

		close();

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
