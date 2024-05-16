package net.acmicpc.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class __Solution_11048 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	// 이동하기 - S2
	// https://www.acmicpc.net/problem/11048
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		int n = input[0];
		int m = input[1];

		// 필드 생성
		int[][] field = new int[n][m];
		for (int i = 0; i < input[0]; i++) {
			field[i] = readIntegers();
		}
		int[][] dp = new int[n][m];

		// 시작지점 설정
		dp[0][0] = field[0][0];

		// 1열 계산
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = field[i][0] + dp[i - 1][0];
		}

		// 1행 계산
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = field[0][j] + dp[0][j - 1];
		}

		// 1열, 1행 제외한 갯수 계산
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = field[i][j];
				dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		System.out.println(dp[n - 1][m - 1]);  // 마지막 방의 사탕 갯수 출력
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
