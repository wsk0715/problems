package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최솟값 - G1
 * https://www.acmicpc.net/problem/10868
 */
public class ____Solution_10868 {

	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt(), M = nextInt();

		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = nextInt();
		}
		tree = new long[4 * N];
		build(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			long a = nextLong(), b = nextLong();

			sb.append(query(1, 0, N - 1, (int) a - 1, (int) b - 1)).append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static long build(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start];

		int mid = (start + end) / 2;
		return tree[node] = Math.min(build(node * 2, start, mid),
		                             build(node * 2 + 1, mid + 1, end));
	}

	static long query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return Long.MAX_VALUE;

		if (left <= start && end <= right) return tree[node];

		int mid = (start + end) / 2;
		return Math.min(query(node * 2, start, mid, left, right),
		                query(node * 2 + 1, mid + 1, end, left, right));
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
