package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 7465. 창용 마을 무리의 개수 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
 */
public class Solution_7465_union_find_1 {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 문제 입력 & 변수 초기화
			int N = nextInt();
			int M = nextInt();

			// 유니온 파인드로 풀어보기
			// 부모 배열 초기화; 맨 처음에는 모두 별개의 무리로 구성(자기 자신이 부모)
			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}

			// 간선 정보 입력과 동시에 무리 합치기 (유니온-파인드)
			int cnt = N;
			for (int i = 0; i < M; i++) {
				// 카운팅 방법 최적화; 유니온 파인드가 성공하면 무리 수 -1
				if (union(nextInt(), nextInt())) {
					cnt -= 1;
				}
			}

			sb.append(cnt);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	// find - 공통 조상을 찾는다. (경로 압축)
	static int find(int x) {
		// 무리의 최종 조상인 경우 (부모가 없는 경우)
		if (parents[x] == x) {
			return x;
		}

		// 무리의 최종 조상을 찾아 최종 조상 반환 & 경로 압축
		return parents[x] = find(parents[x]);
	}

	// union - 합친다.
	static boolean union(int x, int y) {
		// 각 무리의 공통 조상을 찾는다.
		int rootX = find(x);
		int rootY = find(y);

		// 다른 무리인 경우 (공통 조상이 다른 경우)
		if (rootX != rootY) {
			parents[rootY] = rootX;  // 무리 합치기;
			return true;
		}

		return false;  // 그 외; 이미 같은 무리인 경우
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
