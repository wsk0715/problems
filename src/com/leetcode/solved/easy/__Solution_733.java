package com.leetcode.solved.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class __Solution_733 {

	// 733. Flood Fill - Easy
	// https://leetcode.com/problems/flood-fill
	public static void main(String[] args) {
		Solution sol = new Solution();


		// #case 1
		int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		int sr = 1;
		int sc = 1;
		int color = 2;
		System.out.println(Arrays.deepToString(sol.floodFill(image, sr, sc, color)));
		// #case 2
		int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
		int sr2 = 0;
		int sc2 = 0;
		int color2 = 0;
		System.out.println(Arrays.deepToString(sol.floodFill(image2, sr2, sc2, color2)));
	}

	static class Solution {

		public int[][] floodFill(int[][] image, int sr, int sc, int color) {
			// 1. m x n 크기의 정수로 이루어진 2차원 배열 image가 주어진다.
			// 2-1. image[i][j]는 이미지의 각 픽셀 값을 의미한다.
			// 2. 또한 세 정수 sr, sc, color가 주어진다.
			// 2-1. image[sr][sc]에서 시작하여 flood fill을 수행한 결과를 반환하라.
			// 3. flood fill 과정은 다음과 같다.
			// 3-1. 시작 픽셀과, 같은 색상의 인접한 픽셀(상, 하, 좌, 우) 값을 color로 변경한다.
			// 3-2. 새롭게 칠해진 각각의 픽셀에 대해서도 3-1을 반복한다.
			// 3-3. 더 이상 칠할 픽셀이 없다면 flood fill을 종료한다.
			// 4. m, n은 1 이상, 50 이하이다.
			// 4-1. m은 image의 크기, n은 image[i]의 크기이다.
			// 4-2. image[i][j], color는 0 이상, 2^16 이하이다.
			// 4-3. sr, sc는 0 이상, 각각 m, n 이하이다.


			// a. 기존 색상과 color가 같다면, 그대로 반환
			int originalColor = image[sr][sc];
			if (originalColor == color) {
				return image;
			}

			// b. flood fill 실행(너비 우선 탐색)
			int m = image.length;
			int n = image[0].length;
			int[] dx = {0, 1, 0, -1};
			int[] dy = {-1, 0, 1, 0};

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{sr, sc});

			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				int x = current[0];
				int y = current[1];

				image[x][y] = color;

				// 인접 픽셀 확인
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] == originalColor) {
						queue.offer(new int[]{nx, ny});
					}
				}
			}

			// c. 결과 반환
			return image;
		}

	}

}
