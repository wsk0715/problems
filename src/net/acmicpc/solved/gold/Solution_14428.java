package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수열과 쿼리 16 - G1
 * https://www.acmicpc.net/problem/14428
 */
public class Solution_14428 {

	static long[] arr;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();
		arr = new long[N + 1];
		arr[0] = Long.MAX_VALUE;  // 0번에 최대값 할당
		for (int i = 1; i <= N; i++) {
			arr[i] = nextInt();
		}
		tree = new int[4 * N + 1];  // 인덱스 트리
		build(1, 1, N);

		int M = nextInt();
		for (int i = 0; i < M; i++) {
			int a = nextInt(), b = nextInt(), c = nextInt();

//			view(1, 1, N);
//			sb.append("\n");
			if (a == 1) {
				arr[b] = c;
				update(1, 1, N, b);
			} else {
				sb.append(query(1, 1, N, b, c)).append("\n");
			}
//			sb.append("\n");
		}


		System.out.print(sb);
		br.close();
	}

	static int build(int node, int start, int end) {
		if (start == end) return tree[node] = start;

		int mid = (start + end) / 2;
		return tree[node] = calc(build(node * 2, start, mid),
		                         build(node * 2 + 1, mid + 1, end));
	}

	static int update(int node, int start, int end, int idx) {
		if (idx < start || end < idx) return tree[node];

		if (start == end) return tree[node] = start;

		int mid = (start + end) / 2;
		return tree[node] = calc(update(node * 2, start, mid, idx),
		                         update(node * 2 + 1, mid + 1, end, idx));
	}

	static int query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return 0;  // 0번에는 최대값 할당되어 있음

		if (left <= start && end <= right) return tree[node];

		int mid = (start + end) / 2;
		return calc(query(node * 2, start, mid, left, right),
		            query(node * 2 + 1, mid + 1, end, left, right));
	}

	// 인덱스를 받아서 값 비교 후, 값이 더 작은 인덱스를 반환
	static int calc(int i, int j) {
		if (arr[i] <= arr[j]) return i;
		return j;
	}

	static void view(int node, int start, int end) {
		if (start == end) {
			sb.append(arr[start]).append(" ");
			return;
		}

		int mid = (start + end) / 2;
		view(node * 2, start, mid);
		view(node * 2 + 1, mid + 1, end);
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
