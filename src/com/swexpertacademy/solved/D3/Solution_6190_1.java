package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 6190. 정곤이의 단조 증가하는 수 (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWcPjEuKAFgDFAU4
 */
public class Solution_6190_1 {

	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = nextInt();
			}

			int max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int val = arr[i] * arr[j];

					if (!calc(val)) {
						continue;
					}

					max = Math.max(max, val);
				}
			}

			sb.append("#").append(tc).append(" ");
			sb.append(max);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static boolean calc(int val) {
		int prev = Integer.MAX_VALUE;

		// 계산 효율성을 위해 뒤에서부터 단조 감소하는지 확인
		while (val > 0) {
			int cur = val % 10;

			// 단조 감소를 위해서는 prev(뒷자리 수)보다 cur(앞자리 수)가 작거나 같아야 함
			if (cur > prev) {
				return false;
			}

			prev = cur;
			val /= 10;
		}

		return true;
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
