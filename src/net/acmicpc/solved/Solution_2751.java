package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2751 {
	private final static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 수 정렬하기 2 - S5
	// https://www.acmicpc.net/problem/2751
	public static void main(String[] args) throws IOException {
		int n = readInt();

		int[] og = new int[n];
		for (int i = 0; i < n; i++) {
			og[i] = readInt();
		}

		int[] arr = new int[2_000_002];
		for (int i = 0; i < og.length; i++) {
			int v = og[i] + 1_000_001;
			arr[v] = v;
		}

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {

			} else {
				str.append(arr[i] - 1_000_001 + "\n");
			}
		}
		System.out.println(str);
	}


	// Libraries
	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

}
