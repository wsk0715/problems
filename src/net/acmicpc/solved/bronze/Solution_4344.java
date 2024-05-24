package net.acmicpc.solved.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4344 {
	private static final Scanner sc = new Scanner(System.in);

	// 평균은 넘겠지 - B1
	// https://www.acmicpc.net/problem/4344
	public static void main(String[] args) {
		int n = readInt();

		double[] avgs = new double[n];
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			double[] scores = Arrays.stream(readInt(m))
									.mapToDouble(j -> (double) j)
									.toArray();
			avgs[i] = Arrays.stream(scores).average().getAsDouble();

			int count = 0;
			for (int j = 0; j < m; j++) {
				if (scores[j] > avgs[i]) {
					count += 1;
				}
			}
			double result = (double) count / m * 100;
			System.out.printf("%.3f%%\n", result);
		}
	}

	// Libraries
	private static String readLine() {
		return sc.nextLine();
	}

	private static int readInt() {
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}

	private static int[] readInt(int n) {
		return Arrays.stream(readLine().trim().split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

}

