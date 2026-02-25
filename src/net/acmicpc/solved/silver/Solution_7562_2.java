package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 나이트의 이동 - S1
 * https://www.acmicpc.net/problem/7562
 */
public class Solution_7562_2 {

	static int T;
	static int L;
	static int[][] map;

	// 방향 벡터 - 상좌, 상우, 하좌, 하우, 좌상, 좌하, 우상, 우하
	static int[] di = {-2, -2, 2, 2, -1, 1, -1, 1};
	static int[] dj = {-1, 1, -1, 1, -2, -2, 2, 2};

	public static void main(String[] args) throws IOException {

		T = nextInt();

		for (int tc = 0; tc < T; tc++) {

			L = nextInt();
			map = new int[L][L];

			// 현재 위치
			int si = nextInt();
			int sj = nextInt();

			// 목표 위치
			int ti = nextInt();
			int tj = nextInt();

			int result = 0;

			// 객체(int[]{i, j, moves}) 생성 비용 최소화하기
			// -> 자바의 컬렉션이 제네릭을 사용하기 때문에 int[]나 Integer나 별 차이 없음
			// -> 원시 자료형(int)를 사용하는 커스텀 큐를 사용해 테스트
			// 결과: 79MB -> 30MB, 256ms -> 208ms로 유의미한 차이
			boolean[][] visited = new boolean[L][L];
			IntQueue q = new IntQueue(L * L);
			q.offer(si * L + sj);
			map[si][sj] = 0;
			visited[si][sj] = true;

			while (!q.isEmpty()) {
				int current = q.poll();
				int ci = current / L;
				int cj = current % L;
				int moves = map[ci][cj];

				if (ci == ti && cj == tj) {
					result = moves;
					break;
				}

				for (int i = 0; i < 8; i++) {
					int ni = ci + di[i];
					int nj = cj + dj[i];

					if (!(0 <= ni && ni < L && 0 <= nj && nj < L)) {
						continue;
					}
					if (visited[ni][nj]) {
						continue;
					}

					q.offer(ni * L + nj);
					map[ni][nj] = map[ci][cj] + 1;
					visited[ni][nj] = true;
				}
			}

			sb.append(result).append("\n");
		}


		System.out.println(sb);
		br.close();
	}

	static class IntQueue {

		int[] queue;
		int head = 0;
		int tail = 0;

		public IntQueue(int size) {
			queue = new int[size];
		}

		public void offer(int value) {
			queue[tail++] = value;
		}

		public int poll() {
			return queue[head++];
		}

		public boolean isEmpty() {
			return head == tail;
		}

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
