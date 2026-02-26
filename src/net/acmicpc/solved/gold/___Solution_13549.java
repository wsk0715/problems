package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 숨바꼭질 3 - G5
 * https://www.acmicpc.net/problem/13549
 */
public class ___Solution_13549 {

	static int N, K;

	public static void main(String[] args) throws IOException {

		N = nextInt();
		K = nextInt();

		// 가장 빠른 시간 찾기? -> BFS
		// 선택지(2)
		// 1. 걷는다. (-1, 1)
		// 2. 순간이동 한다. (x2)

		Deque<Integer> q = new ArrayDeque<>(); // position
		int[] dists = new int[100_001];
		Arrays.fill(dists, Integer.MAX_VALUE);

		q.offer(N);
		dists[N] = 0;

		while (!q.isEmpty()) {
			int pos = q.poll();

			if (pos == K) {
				break;
			}

			// 비용이 들지 않는 순간이동 먼저(최단 시간) dists 배열 계산
			if (pos * 2 < 100_001) {
				// 현재 시간이 더 짧은 경우에만 갱신
				if (dists[pos] < dists[pos * 2]) {
					q.offer(pos * 2);
					dists[pos * 2] = dists[pos];
				}
			}
			if (pos - 1 >= 0) {
				if (dists[pos] + 1 < dists[pos - 1]) {
					q.offer(pos - 1);
					dists[pos - 1] = dists[pos] + 1;
				}
			}
			if (pos + 1 < 100_001) {
				if (dists[pos] + 1 < dists[pos + 1]) {
					q.offer(pos + 1);
					dists[pos + 1] = dists[pos] + 1;
				}
			}
		}

		sb.append(dists[K]);
		System.out.println(sb);
		br.close();
	}


	// Libraries
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
