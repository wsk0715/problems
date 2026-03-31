package net.acmicpc.solved.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 사탕상자 - P5
 * https://www.acmicpc.net/problem/2243
 */
public class ____Solution_2243 {

	static long[] tree;

	static int FLAVOR_MIN = 1, FLAVOR_MAX = 1_000_000;

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();

		tree = new long[4 * FLAVOR_MAX];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int A = nextInt(), B = nextInt();
			if (A == 1) {
				int flavor = query(1, FLAVOR_MIN, FLAVOR_MAX, B);
				update(1, FLAVOR_MIN, FLAVOR_MAX, flavor, -1);
				sb.append(flavor).append("\n");
			} else {
				int C = nextInt();
				update(1, FLAVOR_MIN, FLAVOR_MAX, B, C);
			}
		}

		System.out.print(sb);
		br.close();
	}

	// 쿼리 - K번째 사탕의 맛 반환
	static int query(int node, int start, int end, int rank) {
		// 종료 조건; 리프 노드 도달 - 현재 노드의 맛을 반환
		if (start == end) return start;

		// 원하는 rank가 왼쪽, 오른쪽 노드 어디에 있는지 확인 & 재귀 호출
		int mid = (start + end) / 2;
		long leftSize = tree[node * 2];
		if (rank <= leftSize) {
			return query(node * 2, start, mid, rank);
		} else {
			int newRank = (int) (rank - leftSize);
			return query(node * 2 + 1, mid + 1, end, newRank);
		}
	}

	static void update(int node, int start, int end, int idx, int diff) {
		if (idx < start || end < idx) return;

		tree[node] += diff;
		if (start == end) return;

		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, diff);
		update(node * 2 + 1, mid + 1, end, idx, diff);
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
