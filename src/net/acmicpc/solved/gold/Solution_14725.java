package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * 개미굴 - G3
 * https://www.acmicpc.net/problem/14725
 */
public class Solution_14725 {

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();

		Node trie = new Node();
		for (int asdf = 0; asdf < N; asdf++) {
			st = new StringTokenizer(br.readLine().trim());

			int K = nextInt();

			Node cur = trie;
			for (int i = 0; i < K; i++) {
				String name = st.nextToken();

				if (cur.children.get(name) == null) {
					cur.children.put(name, new Node());
				}
				cur = cur.children.get(name);
			}
		}
		dfs(trie, 0);

		System.out.print(sb);
		br.close();
	}

	static void dfs(Node node, int depth) {
		for (String s : node.children.keySet()) {
			for (int i = 0; i < depth; i++) {
				sb.append("--");
			}
			sb.append(s).append("\n");
			dfs(node.children.get(s), depth + 1);
		}
	}


	static class Node {

		Map<String, Node> children = new TreeMap<>();  // 내부적으로 정렬되는 TreeMap 사용

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
