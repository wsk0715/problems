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
public class ___Solution_17471_union_find {

	static int[] parents;

	static int N;
	static int[] pops;
	static List<Integer>[] graph;
	static int[] groups;
	static int sizeA;
	static int result;

	public static void main(String[] args) throws IOException {
		init();

		// BFS 대신 유니온 파인드를 이용한 풀이

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
		int nodeCnt = (group == 1) ? sizeA : (N - sizeA);  // 해당 그룹 노드 수

		// 유니온 파인드 초기화(각 노드의 부모를 자기자신으로 설정)
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		// 유니온 파인드 수행(같은 그룹 내)
		int cnt = nodeCnt; // 초기엔 각 노드가 별개의 무리
		for (int i = 1; i <= N; i++) {
			if (groups[i] != group) continue;

			for (int next : graph[i]) {
				if (groups[next] == group) {
					// union 시도;성공 시 무리 수 감소
					if (union(i, next)) {
						cnt -= 1;
					}
				}
			}
		}

		// 최종적으로 남은 무리가 1개인지 확인 & 결과 반환
		return cnt == 1;
	}

	static boolean union(int u, int v) {
		int rootU = find(u);
		int rootV = find(v);

		if (rootU != rootV) {
			parents[rootV] = rootU;
			return true;
		}

		return false;
	}

	static int find(int u) {
		if (parents[u] == u) return u;
		return parents[u] = find(parents[u]);
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
