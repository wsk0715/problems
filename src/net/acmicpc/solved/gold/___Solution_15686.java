package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ___Solution_15686 {

	static int N, M;
	static int[][] city;
	static List<int[]> houses = new ArrayList<>(), chickens = new ArrayList<>();
	static int minDistance = Integer.MAX_VALUE;

	// 치킨 배달 - G5
	// https://www.acmicpc.net/problem/15686
	public static void main(String[] args) throws IOException {
		// 도시의 치킨 거리 = sum(치킨 거리)
		// 치킨 거리 = 집에서 가장 가까운 치킨집까지의 거리
		// M개의 치킨집을 제외하고 모두 제거한다. 이 때 도시의 치킨 거리를 구하는 문제

		// a. 변수 입력
		N = nextInt();
		M = nextInt();
		city = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				city[i][j] = nextInt();
				if (city[i][j] == 1) {
					houses.add(new int[]{i, j});  // 집 좌표 입력
					continue;
				}
				if (city[i][j] == 2) {
					chickens.add(new int[]{i, j});  // 치킨집 좌표 입력
				}
			}
		}

		// b. M개의 치킨집 조합 생성 및 도시의 치킨 거리 계산
		combination(new int[M], 0, 0);

		// 결과 출력
		write(minDistance);

		close();
	}

	private static void combination(int[] selectedChickenIndices, int depth, int startFrom) {
		// 치킨집 조합 생성하는 메소드(백트래킹)
		// selectedChickenIndices - 선택된 치킨집의 조합(인덱스)

		// a. 종료 조건
		if (depth == M) {
			// 지금까지 선택된 치킨집 조합에 대해 도시의 치킨 거리 계산
			calculateCityDistance(selectedChickenIndices);
			return;
		}

		// b. 치킨집 목록에서 임의로 M개의 치킨집 선택
		for (int i = startFrom; i < chickens.size(); i++) {
			selectedChickenIndices[depth] = i;  // m번째 치킨집의 인덱스
			combination(selectedChickenIndices, depth + 1, i + 1);  // M개의 치킨집이 선택될 때까지 재귀
		}
	}

	private static void calculateCityDistance(int[] selectedChickenIndices) {
		// 도시 치킨 거리 계산 메소드

		int currentTotalDistance = 0;
		for (int[] house : houses) {
			int hx = house[0];
			int hy = house[1];

			// 각 집에 대해 치킨 거리 계산
			int houseMinDistance = Integer.MAX_VALUE;
			for (int index : selectedChickenIndices) {
				int[] chicken = chickens.get(index);
				int cx = chicken[0];
				int cy = chicken[1];

				int distance = Math.abs(hx - cx) + Math.abs(hy - cy);
				houseMinDistance = Math.min(houseMinDistance, distance);
			}

			// 현재 도시 치킨 거리에 추가
			currentTotalDistance += houseMinDistance;
		}

		// 최소거리 비교
		minDistance = Math.min(minDistance, currentTotalDistance);
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
