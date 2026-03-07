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
public class Solution_14229_quick_hoare {

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

			// 퀵 정렬 구현(Hoare-Partition)
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

	// 호어파티션
	private static int partition(int start, int end) {
		int pivot = arr[start];  // 가장 왼쪽에 있는 값을 pivot으로 간주

		int l = start + 1;  // 피봇보다 큰 수를 찾는 포인터
		int r = end;        // 피봇보다 작거나 같은 수를 찾는 포인터

		while (l <= r) {
			// pivot보다 큰 값을 찾을 때까지 l 증가
			while (arr[l] <= pivot) {
				l += 1;
			}
			// pivot보다 작거나 같은 값을 찾을 때까지 r 감소
			while (arr[r] > pivot) {
				r -= 1;
			}

			// 아직 교차되지 않은 경우, 스왑
			if (l < r) {
				int tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
			}
		}

		// 가장 왼쪽에 있는 값을 pivot이라 정의했으므로, 스왑
		int tmp = arr[start];
		arr[start] = arr[r];
		arr[r] = tmp;

		return r;
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
