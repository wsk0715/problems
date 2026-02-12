package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2817. 부분 수열의 합 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7IzvG6EksDFAXB
 */
public class Solution_2817 {

	static int N;
	static int K;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = nextInt();
			K = nextInt();

			arr = new int[N];
			result = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = nextInt();
			}

			calc(0, 0);

			sb.append("#").append(tc).append(" ");
			sb.append(result);
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	static void calc(int idx, int sum) {
		// 종료 조건; 합이 K를 넘은 경우 (가지치기)
		if (sum > K) {
			return;
		}

		// 종료 조건; 끝까지 탐색한 경우
		if (idx == N) {
			// 합이 K인 경우; 결과 갱신
			if (sum == K) {
				result += 1;
			}
			return;
		}

		// 현재 요소를 선택하는 경우 호출
		calc(idx + 1, sum + arr[idx]);

		// 현재 요소를 선택하지 않는 경우 호출
		calc(idx + 1, sum);
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
