package com.swexpertacademy.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 2117. 홈 방범 서비스
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
 */
public class Solution_2117_1 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();  // 격자 크기
			int M = nextInt();  // 방범 서비스 수익

			// 완전 탐색 - 시간 오래 걸림 O(N^2 * K^2)
			// 집 좌표를 리스트에 저장하고, 거리 변화에 따라 추가되는 집 수 확인(누적합) -> O(N^2 * houses)?
			List<int[]> houses = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (nextInt() == 1) {
						houses.add(new int[]{i, j});
					}
				}
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 범위마다 모든 k를 순회할 필요 없다. 카운팅 & 누적합 이용
					// how?
					// -> k는 '거리'에 대한 변수이다.
					// -> '거리'는 연속되며 누적되는 자원이다.
					//    (0부터 N거리까지 포함되는 요소를 찾아야 한다면 0부터 N-1까지 + N에 존재하는 요소로 구할 수 있음)
					// -> 따라서 '거리'나 '시간'처럼 주요 조건이 연속된 자원인 경우 누적합 개념을 떠올리면 유용할 수 있음

					// 1. 중심(i, j)으로부터 집까지의 거리 카운팅; 인덱스 = 거리
					int[] houseDistances = new int[2 * N + 1];  // 2*N 인덱스까지 갖는 배열
					for (int[] h : houses) {
						int dist = Math.abs(i - h[0]) + Math.abs(j - h[1]);

						// 인덱스 범위 내인 경우
						if (dist < 2 * N) {
							houseDistances[dist + 1] += 1;  // dist + 1에서부터 범위에 포함됨
						}
					}

					// 2. 카운팅 배열을 이용해 누적합 계산, 결과 갱신
					int cnt = 0;
					for (int k = 1; k <= 2 * N; k++) {
						cnt += houseDistances[k];

						int cost = k * k + (k - 1) * (k - 1);
						if (M * cnt >= cost) {
							result = Math.max(result, cnt);
						}
					}
				}
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
