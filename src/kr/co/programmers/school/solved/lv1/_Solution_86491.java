package kr.co.programmers.school.solved.lv1;

public class _Solution_86491 {

	// 최소직사각형 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/86491
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(sol.solution(sizes));
		// #case 2
		int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		System.out.println(sol.solution(sizes2));
		// #case 3
		int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		System.out.println(sol.solution(sizes3));
	}

	static class Solution {

		public int solution(int[][] sizes) {
			// 가장 긴 가로 길이(x), 가장 긴 세로 길이(y)를 갖는 최소 넓이의 조합 찾기
			// 가능한 경우, 가로와 세로의 길이를 바꿀 수 있음(명함을 눕히는 경우)

			int x = 1;
			int y = 1;

			for (int[] size : sizes) {  // 배열을 순회하며, 세로가 가로보다 긴 명함을 회전시킨다.
				int width = Math.max(size[0], size[1]);
				int height = Math.min(size[0], size[1]);

				if (x < width) {
					x = width;
				}

				if (y < height) {
					y = height;
				}
			}

			return x * y;  // 가장 긴 가로와 가장 긴 세로를 곱한 값이 지갑의 크기가 된다.
		}

	}

}
