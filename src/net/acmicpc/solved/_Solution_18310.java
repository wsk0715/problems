package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_18310 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 안테나 - S3
	// https://www.acmicpc.net/problem/18310
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] houses = readIntegers();

		// 거리의 합이 최소가 되도록 하는 수 : 중앙값 구하는 문제
		Arrays.sort(houses);

		if (n % 2 == 1) {  // 1. 홀수인 경우, 중앙값
			System.out.println(houses[n / 2]);
		} else {  // 2. 짝수인 경우, 둘 중 더 작은 값
			System.out.println(houses[n / 2 - 1]);
		}
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine()
									   .trim());
		return value;
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
