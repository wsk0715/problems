package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 5215. 햄버거 다이어트 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
 */
public class Solution_5215 {

	static int N;
	static int L;
	static int[] scores;
	static int[] calories;
	static int result;

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = nextInt();
			L = nextInt();

			scores = new int[N];
			calories = new int[N];
			result = 0;

			for (int i = 0; i < N; i++) {
				scores[i] = nextInt();
				calories[i] = nextInt();
			}

			calc(0, 0, 0);

			sb.append("#").append(tc).append(" ");
			sb.append(result);
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	static void calc(int idx, int score, int calorie) {
		// 종료 조건; 칼로리가 초과된 경우
		if (calorie > L) {
			return;
		}

		// 종료 조건; 모든 재료를 확인한 경우
		if (idx == N) {
			result = Math.max(result, score);
			return;
		}

		// 현재 메뉴 선택한 경우 계산
		calc(idx + 1, score + scores[idx], calorie + calories[idx]);
		// 현재 메뉴 선택하지 않은 경우 계산
		calc(idx + 1, score, calorie);
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
