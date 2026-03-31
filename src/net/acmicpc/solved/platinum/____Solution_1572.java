package net.acmicpc.solved.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 중앙값 - P5
 * https://www.acmicpc.net/problem/1572
 */
public class ____Solution_1572 {

	static long[] tree;
	static int[] arr;

	static int MAX_SIZE = 65535;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt(), K = nextInt();

		tree = new long[4 * MAX_SIZE + 1];
		arr = new int[N + 1];

		// 0 ~ K-1초
		for (int t = 0; t < K - 1; t++) {
			int n = nextInt();

			arr[t] = n;
			update(1, 0, MAX_SIZE, n, 1);
		}

		// K-1 ~ N초
		int p = 0;
		long sum = 0;
		int mid = (K + 1) / 2;
		for (int t = K - 1; t < N; t++) {

			// 현재 온도 기록
			int in = nextInt();
			arr[t] = in;
			update(1, 0, MAX_SIZE, in, 1);

			// 중앙값 쿼리
			sum += query(1, 0, MAX_SIZE, mid);

			// 윈도우에서 벗어난 요소 제거
			int out = arr[p++];
			update(1, 0, MAX_SIZE, out, -1);
		}

		sb.append(sum).append("\n");
		System.out.print(sb);
		br.close();
	}

	// 자식 요소 수를 카운팅 (value = 1, -1)
	static long update(int node, int start, int end, int idx, int value) {
		if (idx < start || end < idx) return tree[node];

		if (start == end) return tree[node] += value;

		int mid = (start + end) / 2;
		return tree[node] = update(node * 2, start, mid, idx, value)
							+ update(node * 2 + 1, mid + 1, end, idx, value);
	}

	static long query(int node, int start, int end, int rank) {
		if (start == end) return start;

		int mid = (start + end) / 2;
		if (rank <= tree[node * 2]) {
			return query(node * 2, start, mid, rank);
		} else {
			return query(node * 2 + 1, mid + 1, end, rank - (int) tree[node * 2]);
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
