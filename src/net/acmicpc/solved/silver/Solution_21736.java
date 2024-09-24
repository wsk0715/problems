package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_21736 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int M;
	static String[][] field;
	static boolean[][] visited;
	static int count;

	// 헌내기는 친구가 필요해 - S2
	// https://www.acmicpc.net/problem/21736
	public static void main(String[] args) throws IOException {
		int[] NM = readIntegers();
		N = NM[0];
		M = NM[1];

		// 그래프 입력, I 위치 찾기
		field = new String[N][];
		int y = -1;
		int x = -1;
		for (int i = 0; i < N; i++) {
			field[i] = new String[M];
			String[] line = readLine().split("");

			for (int j = 0; j < M; j++) {
				if (line[j].equals("I")) {
					y = i;
					x = j;
				}
				field[i][j] = line[j];
			}
		}
		// #logging
		//		for (int i = 0; i < field.length; i++) {
		//			System.out.println(Arrays.toString(field[i]));
		//		}
		visited = new boolean[N][M];

		// 탐색 시작
		count = 0;
		dfs(y, x);

		// #logging
		//		for (int i = 0; i < N; i++) {
		//			System.out.println(Arrays.toString(visited[i]));
		//		}

		write(count > 0 ? count : "TT");

		close();
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		// #logging
		//		System.out.printf("visiting : [%s, %s]\n", y, x);

		if (field[y][x].equals("P")) {
			count += 1;
		}

		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
				if (!visited[ny][nx] && !field[ny][nx].equals("X")) {
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
