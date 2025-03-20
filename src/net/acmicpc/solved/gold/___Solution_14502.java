package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ___Solution_14502 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[][] field;
	static int maxSafeArea = 0;

	// 연구소 - G4
	// https://www.acmicpc.net/problem/14502
	public static void main(String[] args) throws IOException {
		int[] l1 = readIntegers();
		N = l1[0];
		M = l1[1];

		// a. 벽 정보 입력
		field = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// b. 벽 세우기 & 바이러스 확산
		simulateWall(0);

		// c. 결과 출력
		write(maxSafeArea);

		close();
	}

	private static void simulateWall(int count) {
		// DFS, 백트래킹을 이용해 벽 세우기

		// a. 종료 조건(백트래킹)
		if (count == 3) {  // a-1. 3개의 벽을 모두 세웠을 시,
			spreadVirus();  // a-2. 바이러스 확산 시작
			return;
		}

		// b. 벽 세우기 시도
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (field[i][j] == 0) {  // b-1. 현재 칸이 비어있는 경우
					field[i][j] = 1;  // b-2. 벽 설치

					simulateWall(count + 1);

					field[i][j] = 0;  // b-3. 벽 제거
				}
			}
		}

	}

	private static void spreadVirus() {
		// 바이러스 확산 시뮬레이션

		// a. 필드 복제
		int[][] tempField = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempField[i] = field[i].clone();
			}
		}

		// b. 그래프 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempField[i][j] == 2) {  // b-1. 바이러스를 발견한 경우
					dfs(tempField, i, j);  // b-2. 현재 위치에서 탐색 시작
				}
			}
		}

		// c. 필드 탐색하며 안전 구역 크기 계산
		int safeArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempField[i][j] == 0) {
					safeArea += 1;
				}
			}
		}

		// d. 최대값 갱신
		maxSafeArea = Math.max(safeArea, maxSafeArea);
	}

	private static void dfs(int[][] field, int x, int y) {
		// DFS를 이용해 그래프 탐색 및 바이러스 확산

		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < 4; i++) {
			// a. 좌표 설정
			int nx = x + dx[i];
			int ny = y + dy[i];

			// b. 탐색
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {  // b-1. 경계 조건 확인
				if (field[nx][ny] == 0) {  // b-2. 빈 공간인 경우
					field[nx][ny] = 2;  // b-3. 바이러스 전파
					dfs(field, nx, ny);  // b-4. 다음 탐색(재귀)
				}
			}
		}
	}


	// Libraries
	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	private static int[] readIntegers() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[st.countTokens()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
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
