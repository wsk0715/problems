package com.swexpertacademy.solved;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1952. 수영장
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
 */
public class Solution_1952_1 {

	static int[] prices;
	static int[] plans;
	static int min;

	public static void main(String[] args) throws IOException {
		init();

		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			prices = new int[4];
			for (int i = 0; i < 4; i++) {
				prices[i] = nextInt();
			}
			plans = new int[13];
			for (int i = 1; i <= 12; i++) {
				plans[i] = nextInt();
			}
			min = prices[3];  // 1년권 가격

			calc(1, 0);

			sb.append(min);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static void calc(int month, int sum) {
		// 가지치기
		if (sum >= min) {
			return;
		}

		// 종료 조건
		if (month > 12) {
			min = sum;  // 가지치기 단계에서 min보다 큰 sum은 걸러짐
			return;
		}

		// 이번달에 수영 계획이 없는 경우
		if (plans[month] == 0) {
			calc(month + 1, sum);
			return;
		}

		// 1년권은 기본값이기 때문에 탐색 x

		// 3개월권
		calc(month + 3, sum + prices[2]);

		// 1개월권 & 1일권 비교
		calc(month + 1, sum + Math.min(prices[1], prices[0] * plans[month]));
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
