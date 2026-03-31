package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 구간 곱 구하기 - G1
 * https://www.acmicpc.net/problem/11505
 */
public class ____Solution_11505 {

	static long[] arr;
	static long[] tree;

	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt(), M = nextInt(), K = nextInt();

		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = nextInt();
		}
		tree = new long[4 * N];
		build(1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			int a = nextInt(), b = nextInt(), c = nextInt();

			if (a == 1) {
				int idx = b - 1;
				arr[idx] = c;

				update(1, 0, N - 1, idx, arr[idx]);
			} else {
				int from = b - 1;
				int to = c - 1;

				sb.append(query(1, 0, N - 1, from, to)).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	static long build(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start] % MOD;

		int mid = (start + end) / 2;
		return tree[node] = (build(node * 2, start, mid)
		                     * build(node * 2 + 1, mid + 1, end)) % MOD;
	}

	static long update(int node, int start, int end, int idx, long value) {
		if (idx < start || end < idx) return tree[node];

		if (start == end) return tree[node] = value;

		int mid = (start + end) / 2;
		return tree[node] = (update(node * 2, start, mid, idx, value)
		                     * update(node * 2 + 1, mid + 1, end, idx, value)) % MOD;

	}

	static long query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 1;

		if (left <= start && end <= right) return tree[node];

		int mid = (start + end) / 2;
		return (query(node * 2, start, mid, left, right)
		        * query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
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
