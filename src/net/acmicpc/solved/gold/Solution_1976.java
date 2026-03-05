package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 여행 가자 - G4
 * https://www.acmicpc.net/problem/1976
 */
public class Solution_1976 {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		int N = nextInt(), M = nextInt();

		// 무리 초기화
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		// 여행 계획 입력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int val = nextInt();
				if (val == 1) {
					union(i, j);
				}
			}
		}

		// 여행 계획 수행
		boolean flag = true;
		int root = -1;
		for (int i = 0; i < M; i++) {
			if (root == -1) {
				root = find(nextInt());
				continue;
			}

			// 하나라도 조상이 다른 경우, 실패
			if (find(nextInt()) != root) {
				flag = false;
				break;
			}
		}


		System.out.print(flag ? "YES" : "NO");
		br.close();
	}

	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

	static boolean union(int x, int y) {
		int rx = find(x);
		int ry = find(y);

		if (rx != ry) {
			parents[ry] = rx;
			return true;
		}

		return false;
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
