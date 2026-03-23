package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 모든 순열 - S3
 * https://www.acmicpc.net/problem/10974
 */
public class Solution_10974 {

	static int N;
	static boolean[] selected;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		init();

		N = nextInt();
		arr = new int[N];
		selected = new boolean[N];

		calc(0);

		System.out.print(sb);
		br.close();
	}

	static void calc(int idx) {
		if (idx > N - 1) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i]) continue;

			selected[i] = true;
			arr[idx] = i + 1;
			calc(idx + 1);
			selected[i] = false;
		}
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
