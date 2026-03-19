package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 게리맨더링 - G3
 * https://www.acmicpc.net/problem/17471
 */
public class ___Solution_17471 {

	static int N;
	static int[] pops;
	static List<Integer>[] graph;
	static int[] groups;
	static int sizeA;
	static int result;

	public static void main(String[] args) throws IOException {
		init();

		// 지역을 두 개의 선거구로 나누기
		// 하나의 선거구 내의 지역은 모두 연결되어야
		// 그래프 문제인가? 연결요소?
		// 그래프는 주어진다. 이미 연결은 되어있는 것
		// 재귀로 모든 조합 추출 & 추출후 유니온 파인드? 유니온파인드 하면 복원은 어떻게? 그냥 BFS?

		// 입력 & 변수 초기화
		N = nextInt();
		pops = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			pops[i] = nextInt();
		}
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int E = Integer.parseInt(st.nextToken());
			for (int j = 0; j < E; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		groups = new int[N + 1];
		sizeA = 0;
		result = Integer.MAX_VALUE;

		// 계산
		calc(1);

		// 결과 출력
		sb.append(result != Integer.MAX_VALUE ? result : -1);
		System.out.print(sb);
		br.close();
	}

	// 조합 구성하며 두 집합이 각각 연결되었는지 확인, 연결되었다면 결과 갱신
	static void calc(int idx) {

		//종료 조건; 모든 구역을 순회한 경우
		if (idx > N) {

			// 두 선거구가 적어도 하나의 지역을 포함하는지 확인
			if (sizeA == 0 || sizeA == N) return;
			// 두 개의 선거구로 나뉘었는지 확인
			if (!isConnected(1) || !isConnected(2)) return;

			// 결과 계산; 두 그룹 간 인구수 차이 계산 & 갱신
			int groupA = 0, groupB = 0;
			for (int i = 1; i <= N; i++) {
				if (groups[i] == 1) {
					groupA += pops[i];
				} else {
					groupB += pops[i];
				}
			}

			result = Math.min(result, Math.abs(groupA - groupB));
			return;
		}

		// 현재 idx를 그룹 1에 넣은 경우 탐색
		groups[idx] = 1;
		sizeA += 1;
		calc(idx + 1);

		// 현재 idx를 그룹 2에 넣은 경우 탐색
		groups[idx] = 2;
		sizeA -= 1;
		calc(idx + 1);
	}

	static boolean isConnected(int group) {
		// 목표 그룹 연결되었는지 탐색
		int cnt = 0;

		// BFS를 통해 지역이 지역구 수 확인
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			// 이미 방문한 경우 생략
			if (visited[i]) continue;

			// 같은 그룹에 대해서만 탐색 수행
			if (groups[i] == group) {
				q.offer(i);
				visited[i] = true;

				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int next : graph[cur]) {
						// 우리 그룹에 속하지 않는경우
						if (groups[next] != group) continue;
						// 이미 방문한 지역인 경우
						if (visited[next]) continue;

						// 탐색 처리
						q.offer(next);
						visited[next] = true;
					}
				}
				// 지역구 하나(탐색 종료)마다 카운트 + 1
				cnt += 1;
			}
		}

		return cnt == 1;  // 하나의 덩어리만 존재해야 함
	}


	// Libraries
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;

	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static void init() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
	}

}
