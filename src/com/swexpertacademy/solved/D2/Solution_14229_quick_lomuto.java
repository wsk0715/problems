package com.swexpertacademy.solved.D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 14229. 백만 개의 정수 정렬 (D2)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AX_Y-4T6-yoDFAVy
 */
public class Solution_14229_quick_lomuto {

	static int[] arr;
	static int[] tmp;

	public static void main(String[] args) throws IOException {
		init();

		int T = 1;
		for (int tc = 1; tc <= T; tc++) {

			arr = new int[1_000_000];
			tmp = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = nextInt();
			}

			// 퀵 정렬 구현 (Lomuto-Partition)
			sort(0, arr.length - 1);

			sb.append(arr[500_000]);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	private static void sort(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);

			sort(start, pivot - 1);
			sort(pivot + 1, end);
		}
	}

	// 로무토파티션
	private static int partition(int start, int end) {
		int pivot = arr[end];  // 가장 오른쪽에 있는 값을 pivot으로 간주

		// 경계 설정
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i += 1;

				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}

		int tmp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = tmp;

		return i + 1;
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
