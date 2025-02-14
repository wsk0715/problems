package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_15663 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] numbers;
	static int[] result;
	static boolean[] visited;

	// N과 M (9) - S2
	// https://www.acmicpc.net/problem/15663
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		N = inputs[0];
		M = inputs[1];

		numbers = readIntegers();
		Arrays.sort(numbers);  // 오름차순 정렬

		result = new int[M];
		visited = new boolean[N];
		dfs(0);

		close();
	}

	static void dfs(int depth) throws IOException {
		// 종료 조건
		if (depth == M) {
			String[] arr = Arrays.stream(result)
								 .mapToObj(String::valueOf)
								 .toArray(String[]::new);
			write(String.join(" ", arr));
			return;
		}

		// 백트래킹
		int prev = -1;  // 직전 숫자 저장
		for (int i = 0; i < N; i++) {
			// 이미 방문했거나, 현재 숫자가 직전 숫자와 동일한 경우
			if (visited[i] || numbers[i] == prev) {
				continue;
			}

			visited[i] = true;  // 현재 숫자 방문 처리

			result[depth] = numbers[i];
			prev = numbers[i];  // 직전 숫자 갱신
			dfs(depth + 1);

			visited[i] = false;  // 백트래킹 종료; 방문 처리 해제
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
