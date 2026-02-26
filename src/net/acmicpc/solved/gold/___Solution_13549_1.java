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
public class ___Solution_13549_1 {

	static int N, K;

	public static void main(String[] args) throws IOException {

		N = nextInt();
		K = nextInt();

		// 0-1 BFS 문제 기초
		// 운 좋게 통과된 부분이 있을 수 있음 --> 리팩토링
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

			// 가중치가 0인 경우
			// (offer에 비해 offerFirst가 성능 상 오버헤드가 있지만 최단 시간 계산 안정성을 위해 수정)
			if (pos * 2 < 100_001) {
				if (dists[pos] < dists[pos * 2]) {
					q.offer(pos * 2);  // 0-1 BFS에서 Deque의 성질을 이용, 큐의 맨앞에 삽입
					dists[pos * 2] = dists[pos];
				}
			}

			// 가중치가 1인 경우
			// (new pos[]{pos-1, pos+1} iterator로 리팩토링할 수 있지만, 객체 생성 비용 최소화를 위해 중복 코드 유지)
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
