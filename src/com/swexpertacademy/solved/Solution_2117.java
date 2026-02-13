package com.swexpertacademy.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2117. 홈 방범 서비스
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
 */
public class Solution_2117 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();  // 격자 크기
			int M = nextInt();  // 방범 서비스 수익

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = nextInt();
				}
			}

			// 방범 영역 설정
			// -> 탐색할 방범 영역 크기 - 도시를 전부 포함할 때까지
			// -> 마름모가 정사각형을 포함하려면 반지름이 2배여야 함
			int result = 0;
			for (int k = 1; k < 2 * N; k++) {
				int cost = k * k + (k - 1) * (k - 1);
				int range = k - 1;  // 범위는 중심 포함, 거리(range)는 중심 제외

				// 주어진 마름모 범위를 이용해(range) 격자 탐색 시작
				int houses = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int profit = -cost;
						int cnt = 0;

						// (i, j)를 중심점으로 마름모 영역 탐색
						for (int ni = i - range; ni <= i + range; ni++) {
							for (int nj = j - range; nj <= j + range; nj++) {
								// 범위 이탈 체크
								boolean con = 0 <= ni && ni < N && 0 <= nj && nj < N;
								if (!con) {
									continue;
								}

								// 거리 계산
								int dist = Math.abs(i - ni) + Math.abs(j - nj);

								// 범위 안에 집이 있을 시, 카운트
								if (dist <= range && map[ni][nj] == 1) {
									profit += M;
									cnt += 1;
								}
							}
						}

						// 현재 방범 범위가 손해보지 않는 경우;
						if (profit >= 0) {
							houses = Math.max(cnt, houses);  // 최대값 갱신
						}
					}
				}
				result = Math.max(result, houses);
			}


			sb.append("#").append(tc).append(" ");
			sb.append(result);
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}


	// Libraries
	private static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
