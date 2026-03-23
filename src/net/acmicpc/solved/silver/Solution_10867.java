package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 중복 빼고 정렬하기 - S5
 * https://www.acmicpc.net/problem/10867
 */
public class Solution_10867 {

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();

		boolean[] cnt = new boolean[2_001];
		for (int i = 0; i < N; i++) {
			cnt[nextInt() + 1000] = true;
		}

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i]) sb.append(i - 1000).append(" ");
		}

		System.out.print(sb);
		br.close();
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
