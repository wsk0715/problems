package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1145 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 적어도 대부분의 배수 - B1
	// https://www.acmicpc.net/problem/1145
	public static void main(String[] args) throws IOException {
		int[] numbers = readIntegers();

		int i = 0;
		while (true) {
			i += 1;

			int r = 0;
			for (int n : numbers) {
				if (i % n == 0) {
					r += 1;
				}
			}

			if (r >= 3) {
				break;
			}
		}
		System.out.println(i);
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
