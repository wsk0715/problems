package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_9655 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 돌 게임 - S5
	// https://www.acmicpc.net/problem/9655
	public static void main(String[] args) throws IOException {
		int n = readInt();

		// 돌 1개: SK
		// 돌 2개: CY
		// 돌 3개: SK
		// 돌 4개: CY
		// 돌 5개: SK
		if (n % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
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
