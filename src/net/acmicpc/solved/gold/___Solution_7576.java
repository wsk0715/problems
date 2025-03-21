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

public class ___Solution_7576 {

	static int N, M;
	static int[][] field;
	static List<int[]> toms = new ArrayList<>();
	static int maxTime = 0;

	// 토마토 - G5
	// https://www.acmicpc.net/problem/7576
	public static void main(String[] args) throws IOException {
		// 익은 토마토 주위의 토마토는 하루가 지나면 익게됨(상하좌우)
		// 1 - 익은 토마토, 0 - 익지 않은 토마토, -1 - 빈 칸
		// 모든 토마토가 익게 되는 최소 일 수 구하는 문제

		M = nextInt();
		N = nextInt();
		field = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				field[i][j] = nextInt();
				if (field[i][j] == 1) {  // 익은 토마토인 경우
					toms.add(new int[]{i, j});  // 좌표 저장
				}
			}
		}

		simulate();
		write(maxTime);

		close();
	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static void simulate() {
		Queue<int[]> queue = new LinkedList<>();
		int[][] visited = new int[N][M];  // 방문 여부 배열 - 익는 데 걸리는 시간
		for (int[] arr : visited) {
			Arrays.fill(arr, -1);
		}

		// BFS 초기값 삽입
		for (int[] tomato : toms) {
			queue.add(tomato);
			visited[tomato[0]][tomato[1]] = 0;  // 익은 토마토의 경우 익는 데 0일 소요
		}

		// BFS 시작
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {  // 경곗값 확인
					if (field[nx][ny] == -1) {  // 빈 칸인 경우, 무시
						continue;
					}

					if (visited[nx][ny] == -1) {  // 방문하지 않았다면
						visited[nx][ny] = visited[x][y] + 1;  // 방문 처리; 인접 칸 방문 시간은 현재 칸 +1
						queue.add(new int[]{nx, ny});  //큐에 삽입
					}
				}
			}
		}

		// 최대값 찾기 & 방문하지 못한 칸 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maxTime = Math.max(maxTime, visited[i][j]);
				if (field[i][j] != -1 && visited[i][j] == -1) {
					maxTime = -1;
					return;
				}
			}
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
