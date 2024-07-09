package io.elice.codeChallenge.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		// n: 배열의 크기, m: 일한 횟수
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		// 주어진 배열 입력
		String[] arr = br.readLine().split(" ");
		int[] numArr = new int[arr.length];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(arr[i]);
		}

		// i: 시작 지점, j: 종료 지점, k: 선택한 수의 위치
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < m; x++) {
			String[] tmpInput = br.readLine().split(" ");
			int i = Integer.parseInt(tmpInput[0]) - 1;
			int j = Integer.parseInt(tmpInput[1]);
			int k = Integer.parseInt(tmpInput[2]) - 1;

			int[] numArrCopy = Arrays.copyOfRange(numArr, i, j);
			Arrays.sort(numArrCopy);
			sb.append(numArrCopy[k]);
			if (x < m - 1) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
