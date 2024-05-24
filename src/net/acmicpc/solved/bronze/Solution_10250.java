package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_10250 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// ACM 호텔 - B3
	// https://www.acmicpc.net/problem/10250
	public static void main(String[] args) throws IOException {
		int t = readInt();

		for (int i = 0; i < t; i++) {
			int[] input = readIntegers();
			int h = input[0], w = input[1], n = input[2];

			System.out.println(sol(h, w, n));
		}

	}

	public static String sol(int height, int width, int number) {
		StringBuilder str = new StringBuilder();

		int n = number;
		int floor = ((n - 1) % height) + 1;
		str.append(floor);

		int room = 1;
		while (n > height) {
			n -= height;
			room += 1;
		}
		str.append((room >= 10) ? "" : "0");
		str.append(room);

		return str.toString();
	}


	// Libraries
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
