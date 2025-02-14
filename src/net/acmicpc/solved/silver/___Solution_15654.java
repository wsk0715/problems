package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_15654 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] range;
	static int[] result;
	static boolean[] visited;

	// N과 M (5) - S3
	// https://www.acmicpc.net/problem/15654
	public static void main(String[] args) throws IOException {
		int[] inputs = readIntegers();
		N = inputs[0];
		M = inputs[1];

		range = readIntegers();
		Arrays.sort(range);// 증가하는 순서로 백트래킹 하기위해 오름차순 정렬

		result = new int[M];
		visited = new boolean[N];  // 방문 여부 배열
		dfs(0);

		close();
	}

	static void dfs(int depth) throws IOException {
		if (depth == M) {
			String[] arr = Arrays.stream(result)
								 .mapToObj(String::valueOf)
								 .toArray(String[]::new);
			write(String.join(" ", arr));
			return;
		}

		for (int i = 0; i < N; i++) {  // range 배열의 값들을 사용해 백트래킹
			if (!visited[i]) {  // 방문하지 않은 숫자만 선택
				visited[i] = true;  // 방문 처리

				result[depth] = range[i];  // 현재 방문한 값을 결과에 저장
				dfs(depth + 1);  // 다음 숫자 탐색

				visited[i] = false;  // 백트래킹(재귀) 종료 시 방문여부 원상복구
			}
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
