package net.acmicpc.solved.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 구간 합 구하기 2 - P4
 * https://www.acmicpc.net/problem/10999
 */
public class ____Solution_10999 {

	static long[] arr;
	static long[] tree;
	static long[] lazy;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt(), M = nextInt(), K = nextInt();

		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = nextLong();
		}
		tree = new long[4 * N + 1];
		build(1, 1, N, tree);
		lazy = new long[4 * N + 1];

		for (int i = 0; i < M + K; i++) {
			int a = nextInt(), b = nextInt(), c = nextInt();

			if (a == 1) {
				long d = nextLong();
				update(1, 1, N, b, c, d);
			} else {
				sb.append(query(1, 1, N, b, c)).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	static long build(int node, int start, int end, long[] tree) {
		if (start == end) return tree[node] = arr[start];

		int mid = (start + end) / 2;
		return tree[node] = build(node * 2, start, mid, tree)
		                    + build(node * 2 + 1, mid + 1, end, tree);
	}

	static long update(int node, int start, int end, int left, int right, long value) {
		push(node, start, end);  // 호출과 동시에 현재 노드에 누적된 지연 합 계산

		if (right < start || end < left) return tree[node];

		if (left <= start && end <= right) {
			lazy[node] += value;  // 지연 합 기록
			push(node, start, end);  // 자식에게 전파(자기자신에게도 적용)
			return tree[node];
		}

		int mid = (start + end) / 2;
		return tree[node] = update(node * 2, start, mid, left, right, value)
		                    + update(node * 2 + 1, mid + 1, end, left, right, value);
	}

	static void push(int node, int start, int end) {
		// 누적된 지연 합이 없는 경우, 종료
		if (lazy[node] == 0) return;

		// 자기자신에게; 구간 길이만큼(자식들 크기만큼) 지연 합 계산
		tree[node] += lazy[node] * (end - start + 1);

		// 자식에게; 리프 노드가 아니라면, 자식 노드에 지연 합 전파
		if (start != end) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}

		// 지연 합 해소
		lazy[node] = 0;
	}

	static long query(int node, int start, int end, int left, int right) {
		push(node, start, end);  // 호출과 동시에 현재 노드에 누적된 지연 합 계산

		if (right < start || end < left) return 0;

		if (left <= start && end <= right) return tree[node];

		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right)
		       + query(node * 2 + 1, mid + 1, end, left, right);
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
