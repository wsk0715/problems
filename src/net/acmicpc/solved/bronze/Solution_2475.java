package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2475 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 검증수 - B5
	// https://www.acmicpc.net/problem/2475
	public static void main(String[] args) throws IOException {
		int[] arr = readIntegers();

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] * arr[i];
		}

		System.out.println(sum % 10);
	}


	// Libraries
	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
