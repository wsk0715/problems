package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1026 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 보물 - S4
	// https://www.acmicpc.net/problem/1026
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] A = readIntegers();
		int[] B = readIntegers();

		// B의 가장 큰 원소가 A의 가장 작은 원소와 곱해지도록 한다.
		Arrays.sort(A);
		Arrays.sort(B);

		int r = 0;
		for (int i = 0; i < A.length; i++) {
			r += A[i] * B[B.length - 1 - i];
		}
		System.out.println(r);
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
