package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3499_4 {

	// 3499. 퍼펙트 셔플 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
	public static void main(String[] args) throws IOException {
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			// ArrayDeque에서는 iterator로 유의미한 차이가 생기지 않음; LinkedList로 변경해서 비교
			Deque<String> d1 = new LinkedList<>();
			Deque<String> d2 = new LinkedList<>();

			for (int i = 0; i < (N + 1) / 2; i++) {
				d1.offer(nextToken());
			}
			for (int i = 0; i < N / 2; i++) {
				d2.offer(nextToken());
			}

			sb.append("#")
			  .append(tc);
			// poll 대신 iterator 사용
			// -> 유의미한 차이 X
			// queue의 poll 연산은 HEAD에서만 일어나기 때문에,
			// 중간 인덱스에 대한 접근을 유지하기 위한 iterator 사용은 필요 없음
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
