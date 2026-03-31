package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최솟값과 최댓값 - G1
 * https://www.acmicpc.net/problem/2357
 */
public class Solution_2357 {

	static int[] arr;
	static long[] maxTree, minTree;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt(), M = nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = nextInt();
		}

		maxTree = new long[4 * N];
		maxBuild(1, 0, N - 1);

		minTree = new long[4 * N];
		minBuild(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			long a = nextLong(), b = nextLong();

			int from = (int) a - 1, to = (int) b - 1;
			sb.append(minQuery(1, 0, N - 1, from, to)).append(" ")
			  .append(maxQuery(1, 0, N - 1, from, to)).append("\n");
		}


		System.out.print(sb);
		br.close();
	}

	static long maxBuild(int node, int start, int end) {
		if (start == end) return maxTree[node] = arr[start];

		int mid = (start + end) / 2;
		return maxTree[node] = Math.max(maxBuild(node * 2, start, mid),
		                                maxBuild(node * 2 + 1, mid + 1, end));
	}
	//	static long maxUpdate(int node, int start, int end, int idx, int value) {
	//		if (idx < start || end < idx) return maxTree[node];
	//
	//		if (start == end) return maxTree[node] = value;
	//
	//		int mid = (start + end) / 2;
	//		return maxTree[node] = Math.max(maxUpdate(node * 2, start, mid, idx, value),
	//		                                maxUpdate(node * 2 + 1, mid + 1, end, idx, value));
	//	}
	static long maxQuery(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return Long.MIN_VALUE;

		if (left <= start && end <= right) return maxTree[node];

		int mid = (start + end) / 2;
		return Math.max(maxQuery(node * 2, start, mid, left, right),
		                maxQuery(node * 2 + 1, mid + 1, end, left, right));
	}

	static long minBuild(int node, int start, int end) {
		if (start == end) return minTree[node] = arr[start];

		int mid = (start + end) / 2;
		return minTree[node] = Math.min(minBuild(node * 2, start, mid),
		                                minBuild(node * 2 + 1, mid + 1, end));
	}
	//	static long minUpdate(int node, int start, int end, int idx, int value) {
	//		if (idx < start || end < idx) return minTree[node];
	//
	//		if (start == end) return minTree[node] = value;
	//
	//		int mid = (start + end) / 2;
	//		return minTree[node] = Math.min(minUpdate(node * 2, start, mid, idx, value),
	//		                                minUpdate(node * 2 + 1, mid + 1, end, idx, value));
	//	}
	static long minQuery(int node, int start, int end, int left, int right) {
		if (right < start || end < left) return Long.MAX_VALUE;

		if (left <= start && end <= right) return minTree[node];

		int mid = (start + end) / 2;
		return Math.min(minQuery(node * 2, start, mid, left, right),
		                minQuery(node * 2 + 1, mid + 1, end, left, right));
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
