package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_15650 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] result;

	// N과 M (2) - S3
	// https://www.acmicpc.net/problem/15650
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		N = inputs[0];
		M = inputs[1];

		// 백트래킹(back tracking)을 활용한 풀이
		result = new int[M];  // 결과를 저장할 배열의 크기를 M으로 초기화
		dfs(1, 0);  // 첫 번째 숫자인 1부터 탐색 시작

		close();
	}

	static void dfs(int start, int depth) throws IOException {
		// b. 조건을 만족한 경우, 현재 탐색을 빠르게 종료 후 다음으로 이동
		// 조건 - M개의 숫자가 모인 경우, 출력
		if (depth == M) {
			String[] arr = Arrays.stream(result)
								 .mapToObj(String::valueOf)
								 .toArray(String[]::new);
			write(String.join(" ", arr));
			return;
		}

		// a. 재귀를 활용하여 조건을 만족하는 가능한 모든 조합 탐색
		for (int i = start; i <= N; i++) {
			result[depth] = i;  // result 배열에서 현재 깊이에 해당하는 인덱스의 값을 재설정
			dfs(i + 1, depth + 1);  // 다음 탐색이 현재 숫자보다 큰 숫자부터 시작할 수 있도록 설정
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
