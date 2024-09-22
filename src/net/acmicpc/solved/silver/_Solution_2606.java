package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Solution_2606 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, m, v;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int count = -1;  // 1번 pc 제외

	// 바이러스 - S3
	// https://www.acmicpc.net/problem/2606
	public static void main(String[] args) throws IOException {
		n = readInt();  // 정점, 노드
		m = readInt();  // 간선
		v = 1;  // 시작 노드

		// 그래프 초기화
		init();

		// 그래프 탐색
		dfs(v);

		write(count);

		close();
	}

	private static void init() throws IOException {
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int[] in = readIntegers();
			int a = in[0];
			int b = in[1];

			graph[a].add(b);
			graph[b].add(a);
		}

		visited = new boolean[n + 1];
	}

	private static void dfs(int v) {
		visited[v] = true;
		//		write(String.format("visiting: [%s]", v));

		for (Integer node : graph[v]) {
			if (!visited[node]) {
				dfs(node);
			}
		}

		count += 1;
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
