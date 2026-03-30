package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 좌표 압축 - S2
 * https://www.acmicpc.net/problem/18870
 */
public class Solution_18870_tree_set {

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();
		int[] query = new int[N];
		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			int n = nextInt();

			query[i] = n;
			set.add(n);
		}

		Map<Integer, Integer> rankMap = new HashMap<>();
		int rank = 0;
		for (int value : set) {
			rankMap.put(value, rank++);
		}

		for (int i : query) {
			sb.append(rankMap.get(i)).append(" ");
		}

		System.out.println(sb);
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
