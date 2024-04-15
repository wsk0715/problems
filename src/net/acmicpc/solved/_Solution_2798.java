package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_2798 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 블랙잭 - B2
	// https://www.acmicpc.net/problem/2798
	public static void main(String[] args) throws IOException {
		int[] n = readIntegers();
		int t = n[1];
		int[] numbers = readIntegers();

		int closest = 0;
		int max = 0;
		for (int j = 0; j < numbers.length - 2; j++) {
			for (int k = j + 1; k < numbers.length - 1; k++) {
				for (int l = k + 1; l < numbers.length; l++) {
					int sum = numbers[j] + numbers[k] + numbers[l];
					if (sum > t) {  // 합이 t보다 크다면
						continue;  // 무시
					}
					if (sum < max) {  // 새로운 합이 기존 합보다 작다면
						continue; // 무시
					}
					closest = sum;
					max = sum;
				}
			}
		}
		System.out.println(closest);
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
