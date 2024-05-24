package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1920 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 수 찾기 - S4
	// https://www.acmicpc.net/problem/1920
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] comp = readIntegers();
		int m = readInt();
		int[] arr = readIntegers();
		Arrays.sort(comp);
		for (int j = 0; j < arr.length; j++) {
			System.out.println(sol(comp, arr[j]));
		}
	}

	public static int sol(int[] array, int n) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (array[mid] == n) {
				return 1;
			} else if (n < array[mid]) {
				end = mid - 1;
			} else if (array[mid] < n) {
				start = mid + 1;
			}
		}
		return 0;
	}

	// Libraries
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
