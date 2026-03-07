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
public class Solution_14229_merge {

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

			// 병합 정렬 구현
			sort(arr);

			sb.append(arr[500_000]);
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	private static void sort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}

		mergeSort(0, arr.length - 1);
	}

	private static void mergeSort(int left, int right) {
		// 기저조건; 정렬 대상 범위가 유효할 때
		if (left >= right) {
			return;
		}

		// 왼쪽 절반, 오른쪽 절반으로 분할, 재귀 호출
		int mid = (left + right) / 2;
		mergeSort(left, mid);
		mergeSort(mid + 1, right);

		// 결과 병합
		merge(left, mid, right);
	}

	private static void merge(int left, int mid, int right) {
		// 원본 배열의 값을 정렬 대상 범위만큼 tmp 배열에 보존
		for (int i = left; i <= right; i++) {
			tmp[i] = arr[i];
		}

		// 포인터 설정
		int leftIdx = left;
		int rightIdx = mid + 1;
		int idx = left;

		// tmp에서 왼쪽 뭉치, 오른쪽 뭉치 값을 뽑아 비교하며 원본 배열(arr)에 기록
		while (leftIdx <= mid && rightIdx <= right) {
			// 왼쪽 값과 오른쪽 값 중 더 작은 값을 원본 배열에 기록
			if (tmp[leftIdx] <= tmp[rightIdx]) {
				arr[idx++] = tmp[leftIdx++];
			} else {
				arr[idx++] = tmp[rightIdx++];
			}
		}

		// 왼쪽 뭉치에 잔여 데이터가 남았는지 확인, 정렬된 상태이므로 순서대로 채워넣기
		while (leftIdx <= mid) {
			arr[idx++] = tmp[leftIdx++];
		}

		// 반대로 오른쪽 뭉치에 잔여 데이터가 남은 경우, arr에 이미 정렬된 순서로 존재하기 때문에 별도 처리 필요 x
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
