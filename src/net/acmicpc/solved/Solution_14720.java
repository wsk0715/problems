package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_14720 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 우유 축제 - B3
	// https://www.acmicpc.net/problem/14720
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] input = readIntegers();

		int milk = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (input[i] == milk) {
				if (milk == 0) {
					count += 1;
					milk = 1;
				} else if (milk == 1) {
					count += 1;
					milk = 2;
				} else if (milk == 2) {
					count += 1;
					milk = 0;
				}
			}
		}
		System.out.println(count);
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
