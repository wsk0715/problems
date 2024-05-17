package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_24416 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 알고리즘 수업 - 피보나치 수 1 - B1
	// https://www.acmicpc.net/problem/24416
	private static int fibonacci;

	public static void main(String[] args) throws IOException {
		int n = readInt();

		// fib() 재귀함수는 항상 1을 반환하기 때문에 재귀 호출 횟수는 해당 피보나치 수와 일치
		System.out.println(fibonacci(n) + " " + fibonacci);
	}

	public static int fibonacci(int n) {
		int[] f = new int[n];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < n; i++) {
			fibonacci += 1;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n - 1];
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
