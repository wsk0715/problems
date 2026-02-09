package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_3499_2 {

	// 3499. 퍼펙트 셔플 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			Deque<String> d1 = new ArrayDeque<>();
			Deque<String> d2 = new ArrayDeque<>();

			for (int i = 0; i < (N + 1) / 2; i++) {
				d1.offer(nextToken());
			}
			for (int i = 0; i < N / 2; i++) {
				d2.offer(nextToken());
			}

			sb.append("#")
			  .append(tc);
			// 시간 복잡도 개선; 매번 큐 순회하지 않고 iterator 활용
			// -> 별 차이 X
			Iterator<String> it1 = d1.iterator();
			Iterator<String> it2 = d2.iterator();
			while (true) {
				if (it1.hasNext()) {
					sb.append(" ").append(it1.next());
				}
				if (it2.hasNext()) {
					sb.append(" ").append(it2.next());
				}
				if (!it1.hasNext() && !it2.hasNext()) {
					break;
				}
			}
			sb.append("\n");
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

}
