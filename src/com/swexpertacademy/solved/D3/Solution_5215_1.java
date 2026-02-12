package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 5215. 햄버거 다이어트 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
 */
public class Solution_5215_1 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int L = nextInt();

			int[] scores = new int[N];
			int[] calories = new int[N];

			for (int i = 0; i < N; i++) {
				scores[i] = nextInt();
				calories[i] = nextInt();
			}

			// 비트 마스킹을 활용한 풀이
			// 재료를 고른 상태를 1, 고르지 않은 상태를 0으로 가정
			int result = 0;
			for (int i = 0; i < (1 << N); i++) {  // (1 << N): N+1개 비트까지; 1, 10, 11, 100, 101 ...
				int score = 0;
				int calorie = 0;

				// j: 0부터 N-1까지
				for (int j = 0; j < N; j++) {
					// 현재 재료를 선택했는지(비트 자릿수 양쪽 모두(&) 1인지) 확인
					if ((i & (1 << j)) != 0) {  // (1 << j): 1을 j만큼 쉬프트 연산; 1, 10, 100, 1000 ...
						score += scores[j];
						calorie += calories[j];
					}
				}

				// 칼로리 제한 확인
				if (calorie <= L) {
					result = Math.max(result, score);
				}
			}
			// 비트 마스킹 방식의 단점
			// -> 복잡한 조건문을 설정할 수 없어, N이 20 이상으로 큰 경우 가지치기가 가능한 재귀가 유리할 수 있음

			sb.append("#").append(tc).append(" ");
			sb.append(result);
			sb.append("\n");
		}

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
