package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _Solution_10026 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static String[][] field;
	static boolean[][] visited;

	// 적록색약 - G5
	// https://www.acmicpc.net/problem/2630
	public static void main(String[] args) throws IOException {
		n = readInt();
		List<Integer> result = new ArrayList<>();

		field = new String[n][n];
		for (int i = 0; i < n; i++) {
			String[] line = readLine().split("");
			field[i] = line;
		}
		// #logging
		//		for (String[] line : field) {
		//			System.out.println(Arrays.toString(line));
		//		}

		// a. 적록색약이 아닌 경우
		visited = new boolean[n][n];
		// #logging
		//		for (boolean[] visit : visited) {
		//			System.out.println(Arrays.toString(visit));
		//		}

		// 그래프 탐색
		int r1 = 0;
		for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[y].length; x++) {
				if (!visited[y][x]) {
					String color = field[y][x];
					dfs(y, x, color);
					r1 += 1;
				}
			}
		}
		result.add(r1);

		// b. 적록색약의 경우
		visited = new boolean[n][n];

		//  빨강 -> 초록 변환; n이 작기 때문에(n < 100), 변환 후 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (field[i][j].equals("R")) {
					field[i][j] = "G";
				}
			}
		}

		// 그래프 탐색
		int r2 = 0;
		for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[y].length; x++) {
				if (!visited[y][x]) {
					String color = field[y][x];
					dfs(y, x, color);
					r2 += 1;
				}
			}
		}
		result.add(r2);

		write(result.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(" ")));

		close();
	}

	private static void dfs(int y, int x, String color) {
		visited[y][x] = true;
		// #logging
		//		System.out.printf("visiting : [%s, %s]\n", y, x);

		int[] dx = {0, 0, -1, 1};  // 상, 하, 좌, 우
		int[] dy = {-1, 1, 0, 0};  // 상, 하, 좌, 우

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
				continue;
			}
			if (!visited[ny][nx] && field[ny][nx].equals(color)) {
				dfs(ny, nx, color);
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
