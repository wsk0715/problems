package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2920 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 음계 - B2
	// https://www.acmicpc.net/problem/2920
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		int[] copy = input.clone();
		Arrays.sort(copy);

		if (checkAsc(input, copy)) {
			System.out.println("ascending");
		} else if (checkDesc(input, copy)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}

	public static boolean checkAsc(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkDesc(int[] a, int[] b) {
		int j = a.length - 1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[j--]) {
				return false;
			}
		}
		return true;
	}

	// Libraries
	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

}
