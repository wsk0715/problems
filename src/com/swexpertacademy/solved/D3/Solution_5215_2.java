package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 5215. 햄버거 다이어트 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
 */
public class Solution_5215_2 {

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

			// 시간 복잡도 개선 - DP를 활용한 풀이
			// 이 문제는 최적 부분 구조가 적용되는 문제 -> 연산 결과 재사용 가능
			// (300칼로리에서 최적의 선택 = 200칼로리에서의 최적의 선택 + 100칼로리에서의 최적의 선택)
			int[] dp = new int[L + 1];  // L 인덱스까지 갖는 배열 초기화
			// 각각의 음식에 대해 반복
			for (int i = 0; i < N; i++) {
				// 중복이 허용되지 않기 때문에, 배열 뒤에서부터 순회하며 계산 결과를 저장
				for (int j = dp.length - 1; j >= calories[i]; j--) {  // calories[i] 이하는 순회할 필요 x
					if (j >= calories[i]) {
						dp[j] = Math.max(dp[j], scores[i] + dp[j - calories[i]]);
					}
				}
			}

			sb.append("#").append(tc).append(" ");
			sb.append(dp[L]);
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
