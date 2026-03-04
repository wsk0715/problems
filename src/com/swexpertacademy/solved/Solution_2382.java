package com.swexpertacademy.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 2382. 미생물 격리
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl
 */
public class Solution_2382 {

	// 방향 벡터 - 상,하,좌,우
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = nextInt(), M = nextInt(), K = nextInt();

			// 박테리아에 위치정보를 저장하기 때문에 oldMap은 필요 없음,
			int[][] newMap = new int[N][N];  // 상태 전이를 방지하기 위해 매 시각 이동을 마친 미생물들 상태만을 기록

			Bacteria[] bacterias = new Bacteria[K];
			for (int i = 0; i < K; i++) {
				Bacteria current = new Bacteria(nextInt(), nextInt(), nextInt(), nextInt() - 1);
				bacterias[i] = current;
			}

			// 시간(M) 루프
			for (int i = 0; i < M; i++) {

				for (int j = 0; j < N; j++) {
					Arrays.fill(newMap[j], -1);
				}

				Arrays.sort(bacterias, Comparator.comparingInt(b -> b.cnt));
				// 박테리아(K) 루프
				for (int j = 0; j < K; j++) {
					Bacteria current = bacterias[j];
					if (current.isDead) {
						continue;
					}

					int ci = current.i;
					int cj = current.j;

					// 다음 위치 계산
					int ni = ci + di[current.dir];
					int nj = cj + dj[current.dir];

					// 약품 구역 처리
					if (ni == 0 || ni == N - 1 || nj == 0 || nj == N - 1) {
						// 사망 처리
						current.cnt /= 2;

						// 방향 전환 처리
						current.dir = calcDir(current.dir);

						// 군집 사멸 처리
						if (current.cnt == 0) {
							newMap[ni][nj] = -1;
							current.isDead = true;
							continue;
						}
					}

					// 이동 처리
					current.i = ni;
					current.j = nj;
					if (newMap[ni][nj] != -1) {  // 누군가 있을 때
						int otherIdx = newMap[ni][nj];

						// 박테리아 배열이 오름차순 정렬되어 있으므로, 새로운(현재) 박테리아가 더 큼
						current.cnt += bacterias[otherIdx].cnt;
						bacterias[otherIdx].isDead = true;
					}
					newMap[ni][nj] = j;
				}
			}

			int result = 0;
			for (Bacteria bacteria : bacterias) {
				if (!bacteria.isDead) {
					result += bacteria.cnt;
				}
			}

			sb.append(result);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	private static int calcDir(int dir) {
		if (dir == 0) {
			return 1;
		} else if (dir == 1) {
			return 0;
		} else if (dir == 2) {
			return 3;
		} else if (dir == 3) {
			return 2;
		}

		return -1;
	}

	static class Bacteria {

		int i;
		int j;
		int cnt;
		int dir;
		boolean isDead;

		Bacteria(int i, int j, int cnt, int dir) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.dir = dir;
			this.isDead = false;
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
