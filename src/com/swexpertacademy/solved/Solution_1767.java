package com.swexpertacademy.solved;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1767. 프로세서 연결하기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
 */
public class Solution_1767 {

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	static int N;
	static int[][] map;
	static int[][] processors;
	static int pCnt;
	static int min;
	static int maxConn;

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = nextInt();
			map = new int[N][N];
			processors = new int[12][2];
			pCnt = 0;
			min = Integer.MAX_VALUE;
			maxConn = -1;

			int pIdx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int val = nextInt();
					map[i][j] = val;

					if (val == 1) {
						processors[pIdx++] = new int[]{i, j};
						pCnt += 1;
					}
				}
			}

			calc(0, 0, 0);

			sb.append(min);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static void calc(int idx, int connected, int cables) {

		// 종료 조건; 모든 프로세서 탐색 시
		if (idx == pCnt) {
			// 연결된 프로세서 수가 많은 경우, 항상 갱신
			if (connected > maxConn) {
				maxConn = connected;
				min = cables;
			}
			// 프로세서 수가 같은 경우, 더 작은 값 취함
			else if (connected == maxConn) {
				min = Math.min(min, cables);
			}
			return;
		}

		// 가지치기; (남은 코어 + 현재 연결된 코어 < 최대 연결 코어) 일 때
		if (pCnt - idx + connected < maxConn) {
			return;
		}

		int i = processors[idx][0];
		int j = processors[idx][1];

		// 프로세서가 가장자리에 위치한 경우, 전선 연결 필요 없음
		if (0 == i || i == N - 1 || 0 == j || j == N - 1) {
			calc(idx + 1, connected + 1, cables);
			return;
		}

		// 가장자리에 위치하지 않은 경우, 4방향으로 전선 연결 & 백트래킹(해제)
		for (int dir = 0; dir < 4; dir++) {

			boolean available = true;
			// 현재 위치 포함x
			for (int k = 1; k < N; k++) {
				int ni = i + di[dir] * k;
				int nj = j + dj[dir] * k;

				if (0 <= ni && ni < N && 0 <= nj && nj < N) {
					// 진행 방향이 비어있는지 확인
					if (map[ni][nj] != 0) {
						available = false;  // 플래그 설정 & 현재 방향 탐색 종료
						break;
					}
				}
			}

			// 현재 방향 진행 가능한 경우, 전선 채우기 & 다음 재귀 호출
			if (available) {
				int cnt = fill(idx, dir, 2);
				calc(idx + 1, connected + 1, cables + cnt);
				fill(idx, dir, 0);  // 백트래킹
			}
		}

		// 현재 프로세서를 연결하지 않는 경우도 탐색
		calc(idx + 1, connected, cables);
	}

	static int fill(int idx, int dir, int value) {
		int cnt = 0;
		// 현재 위치 포함x
		for (int k = 1; k < N; k++) {
			int ni = processors[idx][0] + di[dir] * k;
			int nj = processors[idx][1] + dj[dir] * k;

			if (0 <= ni && ni < N && 0 <= nj && nj < N) {
				map[ni][nj] = value;
				cnt += 1;
				continue;
			}
			break;
		}
		return cnt;
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

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
