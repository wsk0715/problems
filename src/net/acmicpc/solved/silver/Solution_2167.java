package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2167 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 2차원 배열의 합 - S5
	// https://www.acmicpc.net/problem/2167
	public static void main(String[] args) throws IOException {
		int[] n = readIntegers();
		int[][] arr = new int[n[0]][n[1]];
		for (int i = 0; i < n[0]; i++) {
			int[] tmp = readIntegers();
			for (int j = 0; j < n[1]; j++) {
				arr[i][j] = tmp[j];
			}
		}

		int a = readInt();
		for (int i = 0; i < a; i++) {
			int sum = 0;
			int[] idxs = readIntegers();
			for (int j = idxs[0] - 1; j < idxs[2]; j++) {
				for (int k = idxs[1] - 1; k < idxs[3]; k++) {
					sum += arr[j][k];
				}
			}
			System.out.println(sum);
		}

	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
