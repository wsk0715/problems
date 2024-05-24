package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_14916 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 거스름돈 - S5
	// https://www.acmicpc.net/problem/14916
	public static void main(String[] args) throws IOException {
		int target = readInt();

		// 거스름돈 종류 - 2원, 5원
		// 동전의 개수가 최소가 되도록

		// 큰 단위 -> 작은 단위
		// 1. 5원짜리 동전 갯수를 기준으로(인덱스: 5원짜리 동전 개수)
		int[] counts = new int[target / 5 + 1];
		for (int i = 0; i < counts.length; i++) {
			int remain = target - (5 * i);
			if (remain % 2 == 0) {
				counts[i] += i;
				counts[i] += remain / 2;
			}
		}

		// 2. 최소값 도출
		int min = Integer.MAX_VALUE;
		for (int count : counts) {
			if (count == 0) {
				continue;
			}
			if (count < min) {
				min = count;
			}
		}

		// 3. 결과 출력
		int r = min == Integer.MAX_VALUE ? -1 : min;
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
