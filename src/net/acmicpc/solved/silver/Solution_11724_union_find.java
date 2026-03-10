package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연결 요소의 개수 - S2
 * https://www.acmicpc.net/problem/11724
 */
public class Solution_11724_union_find {

	static int[] parent;
	static int result;

	public static void main(String[] args) throws IOException {

		int N = nextInt(), M = nextInt();

		parent = new int[N + 1];
		// 모든 노드가 연결되어 있지 않다고 가정(자기자신이 뿌리)
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		result = N;  // 초기 연결 요소 수는 노드 수
		for (int i = 0; i < M; i++) {
			int u = nextInt();
			int v = nextInt();

			// 유니온파인드 성공 시 (무리가 합쳐진 경우)
			if (union(u, v)) {
				result -= 1;  // 무리(연결 요소) 갯수 -1
			}
		}

		sb.append(result);
		System.out.print(sb);
		br.close();
	}

	// 특정 노드의 뿌리를 찾는다.
	static int find(int u) {
		// 자기자신이 부모인 경우; 뿌리로 간주
		if (parent[u] == u) {
			return u;
		}

		// 경로 압축; 내 부모의 뿌리를 찾아 나를 직계 자식으로 포함시킨다.
		return parent[u] = find(parent[u]);
	}

	// 두 노드의 뿌리를 찾고, 뿌리가 다르면, 합친다.
	static boolean union(int u, int v) {
		// 각 노드의 뿌리 찾기
		int rootU = find(u);
		int rootV = find(v);

		// 뿌리가 다르면
		if (rootU != rootV) {
			// v를 u의 자식으로 편입(유니온 연산)
			parent[rootV] = rootU;
			return true;
		}

		// 뿌리가 같다면; 유니온 연산 실행하지 않음
		return false;
	}


	// Libraries
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
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

}
