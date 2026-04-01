package net.acmicpc.solved.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 데이터 구조 - P4
 * https://www.acmicpc.net/problem/12899
 */
public class ____Solution_12899 {

	static int[] tree;

	static int MAX_VALUE = 2_000_000;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();

		tree = new int[4 * MAX_VALUE + 1];
		for (int i = 0; i < N; i++) {
			int T = nextInt(), X = nextInt();

			if (T == 1) {
				// 추가
				update(1, 1, MAX_VALUE, X, 1);
			} else {
				// 삭제
				int val = query(1, 1, MAX_VALUE, X);
				update(1, 1, MAX_VALUE, val, -1);
				sb.append(val).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	// 카운팅 세그먼트 트리
	static int update(int node, int start, int end, int idx, int value) {
		if (idx < start || end < idx) return tree[node];

		if (start == end) return tree[node] += value;

		int mid = (start + end) / 2;
		return tree[node] = update(node * 2, start, mid, idx, value)
		                    + update(node * 2 + 1, mid + 1, end, idx, value);
	}

	static int query(int node, int start, int end, int rank) {
		if (start == end) return start;

		int mid = (start + end) / 2;
		if (rank <= tree[node * 2]) {
			return query(node * 2, start, mid, rank);
		} else {
			return query(node * 2 + 1, mid + 1, end, rank - tree[node * 2]);
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
