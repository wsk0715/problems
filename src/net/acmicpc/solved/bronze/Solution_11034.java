package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_11034 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 캥거루 세마리2 - B3
	// https://www.acmicpc.net/problem/11034
	public static void main(String[] args) throws IOException {
		String input;
		while ((input = readLine()) != null) {
			int[] numbers = Arrays
					.stream(input.split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();

			Arrays.sort(numbers);
			int left = numbers[0];
			int mid = numbers[1];
			int right = numbers[2];

			int space = mid - left > right - mid ? mid - left : right - mid;
			System.out.println(space - 1);
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
