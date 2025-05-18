package net.acmicpc.solved.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class __Solution_1697 {

	static int N, K;
	static Queue<int[]> queue;
	static boolean[] visited;

	// 숨바꼭질 - S1
	// https://www.acmicpc.net/problem/1697
	public static void main(String[] args) throws IOException {
		// 1. 입력 받기
		N = nextInt();  // N: 수빈
		K = nextInt();  // K: 동생

		// 2. 필요한 변수 초기화
		queue = new LinkedList<>();
		visited = new boolean[100_001];  // 방문 배열; 동일한 위치 재방문을 방지

		// 3. 시뮬레이션
		// 3-1. 초기 상태 삽입
		queue.add(new int[]{N, 0});  // [수빈이의 초기 위치, 이동횟수]
		visited[N] = true;

		// 3-2. 탐색
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentPosition = current[0];  // 수빈이의 현재 위치
			int currentTime = current[1];      // 현재 이동 횟수

			// a. 종료 조건 확인: 수빈이의 현재 위치가 동생 위치와 일치할 경우
			if (currentPosition == K) {
				write(currentTime);  // 현재 이동횟수 출력 후 반복 종료
				break;
			}

			// b. 다음 탐색 위치 삽입
			addNext(currentPosition, currentTime);
		}

		close();
	}

	static void addNext(int pos, int time) {
		int next;

		// 수빈이는 X 위치에서 세 가지 선택이 가능
		// case 1. 걷기: X-1로 이동
		next = pos - 1;
		if (0 <= next && next <= 100_000 && !visited[next]) {
			queue.add(new int[]{next, time + 1});
			visited[next] = true;  // 현재 위치 방문처리
		}

		// case 2. 걷기: X+1로 이동
		next = pos + 1;
		if (0 <= next && next <= 100_000 && !visited[next]) {
			queue.add(new int[]{next, time + 1});
			visited[next] = true;
		}

		// case 3. 순간이동: 2*X의 위치로 이동
		next = pos * 2;
		if (0 <= next && next <= 100_000 && !visited[next]) {
			queue.add(new int[]{next, time + 1});
			visited[next] = true;
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
