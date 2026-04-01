package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 전화번호 목록 - G4
 * https://www.acmicpc.net/problem/5052
 */
public class ____Solution_5052 {

	public static void main(String[] args) throws IOException {
		init();

		int t = nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = nextInt();

			Node trie = new Node();

			boolean flag = true;
			for (int i = 0; i < n; i++) {
				Node cur = trie;

				for (char c : br.readLine().trim().toCharArray()) {
					int idx = c - '0';

					// 탐색중인 노드가 단어의 끝인 경우, 종료(앞서 삽입된 단어가 현재 단어의 접두사인 경우)
					if (cur.isEndOfWord) {
						flag = false;
						break;
					}

					// 다음 노드로 이동
					if (cur.children[idx] == null) {
						cur.children[idx] = new Node();
					}
					cur = cur.children[idx];
				}

				// 현재 단어 삽입 후, 현재 단어가 앞서 삽입된 단어의 접두사인지 확인
				cur.isEndOfWord = true;
				for (int j = 0; j < 10; j++) {
					if (cur.children[j] != null) {
						flag = false;
						break;
					}
				}
			}
			sb.append(flag ? "YES" : "NO").append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static class Node {

		Node[] children = new Node[10];
		boolean isEndOfWord;

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
