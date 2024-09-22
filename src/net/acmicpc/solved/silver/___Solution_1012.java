package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ___Solution_1012 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int M, N, K;
	static int[][] field;
	static boolean[][] visited;

	// 유기농 배추 - S2
	// https://www.acmicpc.net/problem/1012
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int i = 0; i < n; i++) {
			int[] in = readIntegers();
			M = in[0];
			N = in[1];
			K = in[2];

			field = new int[N][M];  // y, x
			for (int j = 0; j < K; j++) {
				int[] spot = readIntegers();
				int y = spot[0];
				int x = spot[1];

				field[x][y] = 1;
			}

			visited = new boolean[N][M];

			// logging
			//			System.out.println();
			//			for (int j = 0; j < field.length; j++) {
			//				System.out.println(Arrays.toString(field[j]));
			//			}

			// search graph
			int count = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (field[y][x] == 1 && !visited[y][x]) {
						dfs(y, x);
						count += 1;
					}
				}
			}
			write(count);
		}

		close();
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;

		int[] dx = {0, 0, -1, 1};  // 4방향 델타 배열: 상, 하, 좌, 우
		int[] dy = {-1, 1, 0, 0};

		// 상/하/좌/우 탐색: 델타 배열 이용
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 경곗값 계산
			if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
				if (field[ny][nx] == 1 && !visited[ny][nx]) {  // 현재 위치에 양배추가 존재하고, 방문하지 않았으면 
					dfs(ny, nx);  // 깊이 우선 탐색 수행
				}
			}
		}
		// 델타 배열? 인접한 위치로의 변화량(delta)을 저장하여 방향 별 이동을 쉽게 처리하기 위해 사용하는 배열
		// 이 경우 상/하/좌/우로 인접한 경우가 필요하기 때문에 4방향 델타 배열 사용
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
