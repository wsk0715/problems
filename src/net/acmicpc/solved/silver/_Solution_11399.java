package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Solution_11399 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// ATM - S4
	// https://www.acmicpc.net/problem/11399
	public static void main(String[] args) throws IOException {
		int N = readInt();  // 사람 수

		int[] P = Arrays.stream(readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();  // 인출 시간

		// i번째 사람이 인출하기 위한 대기시간: 1번째부터 i-1번째까지 대기시간의 합
		// 대기시간 합의 최소값을 구하는 문제
		// -> 대기시간 합이 최소가 되려면?
		// -> 오름차순으로 정렬하면 될까?

		Arrays.sort(P);
		int r = 0;
		for (int i = 0; i < P.length; i++) {
			int tmp = 0;
			for (int j = 0; j <= i; j++) {
				tmp += P[j];
			}
			r += tmp;
		}
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
