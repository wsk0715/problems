package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 음주 코딩 - G1
 * https://www.acmicpc.net/problem/5676
 */
public class Solution_5676 {

	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		init();

		String line;
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			if (!st.hasMoreTokens()) break;

			int N = nextInt(), K = nextInt();

			arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.signum(nextInt());
			}
			tree = new int[4 * N];
			build(1, 1, N);

			for (int asdf = 0; asdf < K; asdf++) {
				st = new StringTokenizer(br.readLine().trim());

				String command = st.nextToken();
				if ("C".equals(command)) {
					int i = nextInt(), V = nextInt();
					update(1, 1, N, i, V);
				} else {
					int i = nextInt(), j = nextInt();
					calc(query(1, 1, N, i, j));
				}
			}
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static int build(int node, int start, int end) {
		if (start == end) return tree[node] = Integer.signum(arr[start]);

		int mid = (start + end) / 2;
		return tree[node] = build(node * 2, start, mid)
							* build(node * 2 + 1, mid + 1, end);
	}

	static int update(int node, int start, int end, int idx, int value) {
		if (idx < start || end < idx) return tree[node];

		if (start == end) return tree[node] = Integer.signum(value);

		int mid = (start + end) / 2;
		return tree[node] = update(node * 2, start, mid, idx, value)
							* update(node * 2 + 1, mid + 1, end, idx, value);
	}

	static int query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 1;

		if (left <= start && end <= right) return tree[node];

		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right)
			   * query(node * 2 + 1, mid + 1, end, left, right);
	}

	private static void calc(int value) {
		switch (value) {
			case -1:
				sb.append("-");
				break;
			case 0:
				sb.append(0);
				break;
			case 1:
				sb.append("+");
				break;
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
