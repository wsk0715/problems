package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 구간 합 구하기 - G1
 * https://www.acmicpc.net/problem/2042
 */
public class ____Solution_2042_fenwick {

	static int N, M, K;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		init();

		N = nextInt();
		M = nextInt();
		K = nextInt();

		arr = new long[N + 1];
		tree = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = nextLong();
			update(i, arr[i]);
		}

		for (int i = 0; i < M + K; i++) {
			int  a = nextInt();
			int b = nextInt();
			long c = nextLong();

			if (a == 1) {
				long diff = c - arr[b];
				arr[b] = c;
				update(b, diff);
			} else {
				sb.append(sum((int) c) - sum(b - 1)).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	// 인덱스 i의 값을 diff만큼 갱신
	static void update(int i, long diff) {
		while (i <= N) {
			tree[i] += diff;
			i += (i & -i);
		}
	}

	// 1부터 i까지의 합 계산
	static long sum(int i) {
		long sum = 0;
		while (i > 0) {
			sum += tree[i];
			i -= (i & -i);
		}
		return sum;
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

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
