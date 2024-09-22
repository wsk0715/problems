package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_4963 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int m, n;
	static int[][] field;
	static boolean[][] visited;

	// 섬의 개수 - S2
	// https://www.acmicpc.net/problem/4963
	public static void main(String[] args) throws IOException {
		while (true) {
			String input = readLine();
			if (input.equals("0 0")) {
				break;
			}

			int[] inputs = Arrays.stream(input.trim().split(" "))
								 .mapToInt(Integer::parseInt)
								 .toArray();
			n = inputs[0];
			m = inputs[1];

			field = new int[m][n];
			for (int i = 0; i < m; i++) {
				int[] lands = readIntegers();
				for (int j = 0; j < n; j++) {
					field[i][j] = lands[j];
				}
			}
			// logging
			//			for (int i = 0; i < field.length; i++) {
			//				System.out.println(Arrays.toString(field[i]));
			//			}

			visited = new boolean[m][n];


			// 상하좌우 + 대각 -> 8방향 델타 배열 이용
			// 육지 중, 방문하지 않은 지역 탐색
			int count = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (field[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count += 1;
					}
				}
			}
			write(count);
		}

		close();
	}

	private static void dfs(int y, int x) {
		//		System.out.printf("y: [%s], x: [%s]\n", y, x);
		visited[y][x] = true;

		int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};  // 8방향 - 좌상, 상, 우상, 우, 우하, 하, 좌하, 좌
		int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

		// 주변 8방향에 대해
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i]; // 이동할 위치
			int ny = y + dy[i];

			// 새로운 위치 검증
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (field[ny][nx] == 1 && !visited[ny][nx]) {
					dfs(ny, nx);
				}
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
