package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 구간 합 구하기 - G1
 * https://www.acmicpc.net/problem/2042
 */
public class ____Solution_2042 {

	static long[] arr;
	static long[] tree;

	static int N, M, K;

	public static void main(String[] args) throws IOException {
		init();

		N = nextInt();
		M = nextInt();
		K = nextInt();

		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = nextLong();
		}

		tree = new long[4 * N];
		build(1, 0, N - 1);
		for (int i = 0; i < M + K; i++) {
			long a = nextLong(), b = nextLong(), c = nextLong();

			if (a == 1) {
				int idx = (int) b - 1;
				long cur = arr[idx];
				long diff = c - cur;
				arr[idx] = c;

				update(1, 0, N - 1, idx, diff);
			} else {
				int from = (int) b - 1;
				int to = (int) c - 1;

				sb.append(query(1, 0, N - 1, from, to)).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	// 1. 트리 초기화
	static long build(int node, int start, int end) {
		// 종료 조건; 하나의 노드가 대상인 경우, 노드 위치에 값을 할당 & 종료
		if (start == end) return tree[node] = arr[start];

		// 범위를 둘(양쪽 자식 노드)로 나누어 build 호출 & 값 갱신(top-down)
		int mid = (start + end) / 2;
		return tree[node] = build(node * 2, start, mid)
		                    + build(node * 2 + 1, mid + 1, end);
	}

	// 2. 단일 값 갱신
	// start, end - 담당 범위
	// idx - 대상 인덱스
	static void update(int node, int start, int end, int idx, long diff) {
		// 종료 조건; 현재 노드 담당 범위(start~end)가 idx를 포함하지 않으면 종료
		if (idx < start || end < idx) return;

		// 현재 노드가 범위에 idx를 포함하는 경우, 값 갱신
		tree[node] += diff;
		if (start == end) return;

		// 범위를 둘로 나누어 update 호출
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, diff);
		update(node * 2 + 1, mid + 1, end, idx, diff);
	}

	// 3. 구간 조회
	// start, end - 담당 범위(가변)
	// left, right - 쿼리 범위(불변)
	static long query(int node, int start, int end, int left, int right) {
		// 종료 조건; 범위가 완전히 어긋난 경우
		// (쿼리 범위(left~right)와 담당 범위(start~end)가 전혀 중복되지 않는 경우)
		if (right < start || end < left) return 0;

		// 담당 범위가 쿼리 범위에 포함되는 경우, 노드 값 반환
		// (여기서 선택되지 않은 나머지 범위는 다른 탐색 경로에서 반환됨)
		if (left <= start && end <= right) return tree[node];

		// 범위를 만족하지 않는 경우, 담당 범위를 더 잘게 쪼개서 탐색
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
