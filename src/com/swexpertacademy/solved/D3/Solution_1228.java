package com.swexpertacademy.solved.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228 {

	// 1228. 암호문1 (D3)
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
	public static void main(String[] args) throws IOException {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt();

			List<Integer> ll = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				ll.add(nextInt());
			}

			int M = nextInt();
			for (int i = 0; i < M; i++) {
				String command = nextToken();

				if (command.equals("I")) {
					int x = nextInt();
					int y = nextInt();
					for (int j = 0; j < y; j++) {
						ll.add(x, nextInt());
						x += 1;
					}
				}
			}


			sb.append("#")
			  .append(tc);
			Iterator<Integer> it = ll.iterator();
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(it.next());
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
