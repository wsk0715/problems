package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2851 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 슈퍼 마리오 - B1
	// https://www.acmicpc.net/problem/2851
	public static void main(String[] args) throws IOException {
		int[] scores = new int[10];
		for (int i = 0; i < 10; i++) {
			scores[i] = readInt();
		}

		int sum = 0;
		int target = 100;
		for (int i = 0; i < scores.length; i++) {
			int diff1 = Math.abs(target - sum);
			int diff2 = Math.abs(target - (sum + scores[i]));
			if (diff1 < diff2) {  // 기존 합의 차가 새로운 합의 차보다 작을 시
				break;  // 중지
			}
			sum += scores[i];
		}
		System.out.println(sum);
	}


	// Libraries
	private static String readLine() throws IOException {
		return bf.readLine();
	}

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
