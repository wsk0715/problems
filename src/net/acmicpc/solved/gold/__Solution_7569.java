package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class __Solution_7569 {

	static int N, M, L;
	static int[][][] field;
	static List<Tomato> toms = new ArrayList<>();
	static int waitingTom = 0;
	static int maxTime = -1;

	// 토마토 - G5
	// https://www.acmicpc.net/problem/7569
	public static void main(String[] args) throws IOException {
		// 토마토(7576)의 3차원 버전

		N = nextInt();
		M = nextInt();
		L = nextInt();
		field = new int[L][M][N];
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					field[i][j][k] = nextInt();
					if (field[i][j][k] == 0) {
						waitingTom += 1;
						continue;
					}
					if (field[i][j][k] == 1) {
						toms.add(new Tomato(k, j, i));  // 익은 토마토 저장
					}
				}
			}
		}

		// 모든 토마토 익은 상황
		if (waitingTom == 0) {
			write(0);
			close();
			return;
		}

		simulate();
		write(maxTime);

		close();
	}

	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dx = {1, 0, -1, 0, 0, 0};

	static void simulate() {
		Queue<Tomato> queue = new LinkedList<>();
		int[][][] visited = new int[L][M][N];
		for (int[][] arr : visited) {
			for (int[] a : arr) {
				Arrays.fill(a, -1);
			}
		}

		for (Tomato t : toms) {
			queue.add(t);
			visited[t.z][t.y][t.x] = 0;
		}

		while (!queue.isEmpty()) {
			Tomato t = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nz = t.z + dz[i], ny = t.y + dy[i], nx = t.x + dx[i];

				if (nz >= 0 && nz < L && ny >= 0 && ny < M && nx >= 0 && nx < N) {
					if (field[nz][ny][nx] == -1) {
						continue;
					}

					if (visited[nz][ny][nx] == -1) {
						visited[nz][ny][nx] = visited[t.z][t.y][t.x] + 1;
						queue.add(new Tomato(nx, ny, nz));
					}
				}
			}
		}

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					maxTime = Math.max(maxTime, visited[i][j][k]);
					if (field[i][j][k] == 0 && visited[i][j][k] == -1) {
						maxTime = -1;
						return;
					}
				}
			}
		}
	}

	static class Tomato {

		int x, y, z;

		Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}


	// Libraries
	private static StringTokenizer readLine() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	private static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = readLine();
		}
		return Integer.parseInt(st.nextToken());
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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

}
