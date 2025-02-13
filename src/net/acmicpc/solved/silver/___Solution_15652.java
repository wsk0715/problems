package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_15652 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] result;

	// N과 M (4) - S3
	// https://www.acmicpc.net/problem/15652
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		N = inputs[0];
		M = inputs[1];

		result = new int[M];
		dfs(1, 0);

		close();
	}

	static void dfs(int start, int depth) throws IOException {
		if (depth == M) {
			String[] arr = Arrays.stream(result)
								 .mapToObj(String::valueOf)
								 .toArray(String[]::new);
			write(String.join(" ", arr));
			return;
		}

		for (int i = start; i <= N; i++) {  // 고를 수 있는 수의 범위: start부터 N까지
			result[depth] = i;  // 현재 depth에 해당하는 값 저장
			dfs(i, depth + 1);  // 중복을 허용하므로, 다음 탐색도 현재 숫자에서 시작
		}
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
