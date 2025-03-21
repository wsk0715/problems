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

public class ___Solution_17141 {

	static int N, M;
	static int[][] field;
	static List<int[]> viruses = new ArrayList<>();
	static int minTime = Integer.MAX_VALUE;

	// 연구소 2 - G4
	// https://www.acmicpc.net/problem/17141
	public static void main(String[] args) throws IOException {
		// N - 연구소의 크기(NxN), M - 놓을 수 있는 바이러스의 개수
		// 0 - 빈 칸, 1 - 벽, 2 - 바이러스를 놓을 수 있는 칸
		// 특정 위치에 바이러스를 놓으면 바이러스가 복제됨
		// 바이러스는 상하좌우로 복제될 수 있고, 퍼지는 데 1초 소요
		// 바이러스가 모든 빈 칸에 퍼지는 최소 시간을 구하는 문제

		// a. 입력받기
		N = nextInt();
		M = nextInt();
		field = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				field[i][j] = nextInt();
				if (field[i][j] == 2) {  // 바이러스 가능 칸
					viruses.add(new int[]{i, j});
				}
			}
		}

		// b. 바이러스를 놓을 수 있는 조합 찾기
		combination(new int[M], 0, 0);

		write(minTime == Integer.MAX_VALUE ? -1 : minTime);

		close();
	}

	static void combination(int[] selectedIndices, int depth, int start) {
		// 바이러스 M개를 놓을 수 있는 조합 찾기(백트래킹)

		// a. 종료 조건
		if (depth == M) {
			simulate(selectedIndices);
			return;
		}

		// b. 바이러스를 놓을 M개의 조합 선택
		for (int i = start; i < viruses.size(); i++) {
			selectedIndices[depth] = i;
			combination(selectedIndices, depth + 1, i + 1);
		}
	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static void simulate(int[] virusIndices) {
		// 바이러스 확산(BFS)
		Queue<int[]> queue = new LinkedList<>();
		int[][] visited = new int[N][N];  // boolean이 아닌 int를 사용해 도달 시간 기록
		for (int[] arr : visited) {
			Arrays.fill(arr, -1);  // -1 : 미방문
		}

		// 선택된 조합을 큐에 추가(시작 지점)
		for (int index : virusIndices) {
			int[] virus = viruses.get(index);
			queue.add(virus);
			visited[virus[0]][virus[1]] = 0;  // 시작점에 퍼지는 시간은 0
		}

		// BFS 탐색
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			// 상,하,좌,우 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (field[nx][ny] == 1) {  // 벽인 경우, 무시
						continue;
					}

					if (visited[nx][ny] == -1) {  // 방문하지 않은 칸의 경우
						visited[nx][ny] = visited[x][y] + 1;  // 도달 시간은 현재 칸 + 1
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}

		// 최대 시간 계산, 빈 칸이 모두 바이러스로 채워졌는지 확인
		int maxTime = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxTime = Math.max(maxTime, visited[i][j]);  // 최대 시간 갱신

				if (field[i][j] != 1 && visited[i][j] == -1) {  // 벽이 아닌 방문하지 않은 칸이 있는 경우
					return;
				}
			}
		}

		minTime = Math.min(minTime, maxTime);
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
