package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_11659 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// 구간 합 구하기 4 - S3
	// https://www.acmicpc.net/problem/11659
	public static void main(String[] args) throws IOException {
		int[] input = readIntegers();
		int N = input[0];
		int M = input[1];

		// 누적 합(Prefix Sum)
		// 배열의 각 인덱스까지의 누적 합을 미리(입력과 동시에) 계산하여 저장해놓는 방법
		// 이를 통해 특정 구간의 합을 필요할 때 빠르게(상수 시간 내) 구할 수 있다.
		long[] prefixSums = new long[N + 1];
		String[] arr = readLine().trim().split(" ");
		for (int i = 0; i < arr.length; i++) {
			prefixSums[i + 1] = prefixSums[i] + Integer.parseInt(arr[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int seq = 0; seq < M; seq++) {
			int[] input2 = readIntegers();
			int i = input2[0];
			int j = input2[1];

			long sum = prefixSums[j] - prefixSums[i - 1];
			sb.append(sum).append("\n");
		}

		write(sb);
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
