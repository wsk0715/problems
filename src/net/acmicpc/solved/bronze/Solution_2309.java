package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2309 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 일곱 난쟁이 - B1
	// https://www.acmicpc.net/problem/2309
	public static void main(String[] args) throws IOException {
		int n = 9;

		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = readInt();
		}
		Arrays.sort(heights);
		int sum = Arrays.stream(heights).sum();

		int[] liers = new int[2];
		for (int i = 0; i < heights.length - 1; i++) {
			for (int j = i + 1; j < heights.length; j++) {
				int tmp = heights[i] + heights[j];
				if (sum - tmp == 100) {
					liers[0] = heights[i];
					liers[1] = heights[j];
				}
			}
		}

		for (int i = 0; i < heights.length; i++) {
			if (heights[i] == liers[0] || heights[i] == liers[1]) {

			} else {
				System.out.println(heights[i]);
			}
		}
	}


	// Libraries
	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

}
