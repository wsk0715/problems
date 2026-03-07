package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 14229. 백만 개의 정수 정렬 (D2)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AX_Y-4T6-yoDFAVy
 */
public class Solution_14229 {

	public static void main(String[] args) throws IOException {
		init();

		int T = 1;
		for (int tc = 1; tc <= T; tc++) {

			int[] arr = new int[1_000_000];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = nextInt();
			}
			Arrays.sort(arr);

			sb.append(arr[500_000]);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
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

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;

}
