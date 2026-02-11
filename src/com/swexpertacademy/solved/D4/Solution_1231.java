package com.swexpertacademy.solved.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1231. 중위 순회 (D4)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV140YnqAIECFAYD
 */
public class Solution_1231 {

	static int N;
	private static char[] tree;

	public static void main(String[] args) throws IOException {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			N = nextInt();
			tree = new char[N + 1];

			for (int i = 0; i < N; i++) {
				int idx = nextInt();
				tree[idx] = nextToken().charAt(0);

				st = null; // 버퍼 초기화

				// 자식 설정 생략(완전 이진 트리 특징 이용)
			}

			sb.append("#").append(tc).append(" ");
			visit(1);
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}


	private static void visit(int idx) {
		if (idx > N) {
			return;
		}

		// 중위 순회(in-order; LVR)
		visit(idx * 2);      // 왼쪽 자식
		sb.append(tree[idx]);    // 자기 자신
		visit(idx * 2 + 1);  // 오른쪽 자식
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
