package net.acmicpc.solved.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2577 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 숫자의 개수 - B2
	// https://www.acmicpc.net/problem/2577
	public static void main(String[] args) throws IOException {
		int[] input = new int[3];
		for (int i = 0; i < 3; i++) {
			input[i] = readInt();
		}

		String result = String.valueOf(input[0] * input[1] * input[2]);
		int[] arr = new int[10];
		for (int i = 0; i < result.length(); i++) {
			arr[result.charAt(i) - 48] += 1;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	// Libraries
	private static int readInt() throws IOException {
		int value = Integer.parseInt(bf.readLine().trim());
		return value;
	}

}
