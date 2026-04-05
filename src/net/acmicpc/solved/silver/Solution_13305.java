package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 주유소 - S3
 * https://www.acmicpc.net/problem/13305
 */
public class Solution_13305 {

	public static void main(String[] args) throws IOException {

		// 입력 받기 & 변수 할당
		int N = nextInt();
		int[] distances = new int[N - 1];
		for (int i = 0; i < distances.length; i++) {
			distances[i] = nextInt();
		}
		int[] prices = new int[N];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = nextInt();
		}

		// 문제 풀이
		long sum = 0;
		long minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < distances.length; i++) {
			// 최저 가격 갱신
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}

			// 주유 처리
			sum += distances[i] * minPrice;
		}

		// 결과 출력
		sb.append(sum);
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
