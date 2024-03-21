package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_4153 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 직각삼각형 - B3
	// https://www.acmicpc.net/problem/4153
	public static void main(String[] args) throws IOException {
		while (true) {
			int[] arr = readIntegers();
			Arrays.sort(arr);

			if (arr[0] == 0) {
				break;
			} else if (sqr(arr[2]) == sqr(arr[1]) + sqr(arr[0])) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}

	private static int sqr(int n) {
		int value = 1;
		for (int i = 0; i < 2; i++) {
			value *= n;
		}
		return value;
	}

	// Libraries
	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

}
