package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_18110 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// solved.ac - S4
	// https://www.acmicpc.net/problem/18110
	public static void main(String[] args) throws IOException {
		int n = readInt();

		if (n == 0) {
			System.out.println(0);
		} else {
			int[] ratings = new int[n];
			for (int i = 0; i < n; i++) {
				ratings[i] = readInt();
			}
			Arrays.sort(ratings);

			int cut = (int) Math.round(n * 0.15);
			int sum = 0;
			for (int i = cut; i < n - cut; i++) {
				sum += ratings[i];
			}
			int avg = (int) Math.round((double) sum / (n - cut * 2));
			System.out.println(avg);
		}
	}


	// Libraries
	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

}
