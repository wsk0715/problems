package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_11053 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 가장 긴 증가하는 부분 수열 - S2
	// https://www.acmicpc.net/problem/11053
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] numbers = readIntegers();

		// 동적 계획법을 사용한 풀이
		int[] dp = new int[n];

		// dp[i]: number[i]를 마지막 원소로 갖는 가장 긴 증가하는 부분 수열(LIS)의 길이
		// -> 인덱스 0부터 i-1까지 탐색 후, number[i]보다 작은 값이 있다면 기존 값과 비교 후 LIS 값을 갱신한다.
		for (int i = 0; i < n; i++) {
			dp[i] = 1;  // 기본값 1 = 부분 수열이 자기자신만을 포함하는 경우

			for (int j = 0; j < i; j++) {
				if (numbers[i] > numbers[j] && dp[i] < dp[j] + 1) {  // number[i]를 기존 LIS 뒤에 추가할 수 있는 경우
					dp[i] = Math.max(dp[i], dp[j] + 1);  // 기존 값(dp[i])과 새로운 값(dp[j]+1) 중 더 큰 값으로 갱신
				}
			}
		}

		int result = Arrays.stream(dp).max().orElse(1);  // 기본값 1
		write(result);

		close();
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine()
								  .trim());
	}

	private static int[] readIntegers() throws IOException {
		return Arrays.stream(br.readLine()
							   .trim()
							   .split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
	}

	private static <T> void write(T value) throws IOException {
		String s = String.valueOf(value);
		bw.write(s);
		bw.newLine();
	}

	private static void close() throws IOException {
		bw.flush();
		bw.close();
		br.close();
	}

}
