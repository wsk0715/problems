package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_22864 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 피로도 - B2
	// https://www.acmicpc.net/problem/22864
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		int dBurn = input[0];
		int dWork = input[1];
		int dRest = input[2];
		int maxBurn = input[3];

		int hour = 0;
		int sumBurn = 0;
		int sumWork = 0;
		if (dBurn <= maxBurn) {
			while (hour++ < 24) {
				if (sumBurn + dBurn <= maxBurn) {
					sumWork += dWork;
					sumBurn += dBurn;
				} else {
					sumBurn -= dRest;

				}
				if (sumBurn < 0) {
					sumBurn = 0;
				}
			}
			System.out.println(sumWork);
		} else {
			System.out.println(0);
		}
	}


	// Libraries
	private static int[] readIntegers() throws IOException {
		return Arrays.stream(bf.readLine().trim().split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}
