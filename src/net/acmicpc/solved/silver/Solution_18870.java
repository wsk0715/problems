package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 좌표 압축 - S2
 * https://www.acmicpc.net/problem/18870
 */
public class Solution_18870 {

	public static void main(String[] args) throws IOException {
		init();

		int N = nextInt();
		int[] arr = new int[N];
		int[] query = new int[N];

		for (int i = 0; i < N; i++) {
			int n = nextInt();

			arr[i] = n;
			query[i] = n;
		}
		Arrays.sort(arr);

		int size = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0 || arr[i] != arr[i - 1]) {
				arr[size++] = arr[i];
			}
		}

		for (int i = 0; i < N; i++) {
			int target = query[i];

			int left = 0;
			int right = size - 1;
			while (left <= right) {
				int mid = (left + right) / 2;

				int cur = arr[mid];
				if (cur == target) {
					sb.append(mid).append(" ");
					break;
				}

				if (cur < target) left = mid + 1;
				else right = mid - 1;
			}
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
