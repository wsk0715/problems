package net.acmicpc.solved.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 개똥벌레 - G5
 * https://www.acmicpc.net/problem/3020
 */
public class Solution_3020 {

	public static void main(String[] args) throws IOException {
		init();

		// 1. 입력 & 변수 할당
		int N = nextInt();
		int H = nextInt();

		int[] bottom = new int[H + 2]; // 석순 (바닥에서 위로)
		int[] top = new int[H + 2];    // 종유석 (천장에서 아래로)

		for (int i = 0; i < N; i++) {
			int h = nextInt();

			// 종유석/석순 구별 & 카운팅
			if (i % 2 == 0) {
				bottom[h]++;
			} else {
				top[h]++;
			}
		}

		// 2. 누적 합 계산
		// 높이가 h인 장애물은 높이 h-1 이하의 경로에서도 부딪히게 됨
		// 따라서 높은 인덱스에서 낮은 인덱스로 누적합 계산
		for (int i = H - 1; i >= 1; i--) {
			bottom[i] += bottom[i + 1];
			top[i] += top[i + 1];
		}

		int minHits = Integer.MAX_VALUE;
		int count = 0;

		// 3. 각 구간(높이 1부터 H까지)을 비행하며 파괴할 장애물 수 계산
		for (int i = 1; i <= H; i++) {
			// 부딪히는 장애물 수: 높이 i일 때 석순 수 + 종유석 수
			int hits = bottom[i] + top[H - i + 1];

			// 최소값 & 카운트 계산
			if (hits < minHits) {
				minHits = hits;
				count = 1;
			} else if (hits == minHits) {
				count++;
			}
		}

		// 4. 결과 출력
		sb.append(minHits).append(" ").append(count);
		System.out.print(sb);
		br.close();
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
