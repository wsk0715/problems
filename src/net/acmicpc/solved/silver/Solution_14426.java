package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 접두사 찾기 - S1
 * https://www.acmicpc.net/problem/14426
 */
public class Solution_14426 {

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt(), M = nextInt();

		Node trie = new Node();
		for (int i = 0; i < N; i++) {
			Node cur = trie;

			for (char c : br.readLine().trim().toCharArray()) {
				int idx = c - 'a';

				if (cur.children[idx] == null) {
					cur.children[c - 'a'] = new Node();
				}
				cur = cur.children[idx];
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			Node cur = trie;

			boolean flag = true;
			for (char c : br.readLine().trim().toCharArray()) {
				int idx = c - 'a';

				if (cur.children[idx] == null) {
					flag = false;
					break;
				}
				cur = cur.children[idx];
			}
			if (flag) cnt++;
		}

		sb.append(cnt);
		System.out.print(sb);
		br.close();
	}

	static class Node {

		Node[] children = new Node[26];

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
