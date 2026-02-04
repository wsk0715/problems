package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1860_2 {

	// 1860. 진기의 최고급 붕어빵 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();
			int M = nextInt();
			int K = nextInt();

			// 손님 목록에 PriorityQueue를 사용하는 것과 배열(Array)을 사용하는 경우 비교
			boolean result = true;

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = nextInt();
			}
			Arrays.sort(arr);

			int soldBread = 0;
			for (int time : arr) {
				int currentBread = (time / M) * K - soldBread;

				// 현재 손님이 붕어빵 살 수 있는지 확인
				if (currentBread < 1) {
					result = false;
					break;
				}

				// 구매 가능한 경우
				soldBread += 1;
			}


			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(result ? "Possible" : "Impossible")
			  .append("\n");
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

	private static <T> void append(T value) {
		sb.append(value).append("\n");
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
