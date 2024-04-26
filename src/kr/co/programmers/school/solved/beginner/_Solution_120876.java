package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120876 {
	// 겹치는 선분의 길이
	// https://school.programmers.co.kr/learn/courses/30/lessons/120876
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[][] input = {{0, 1}, {2, 5}, {3, 9}};
		sol.solution(input);
	}

	static class Solution {
		public int solution(int[][] lines) {
			// 1. 좌표평면을 배열을 이용해 표현
			int[] field = new int[201];
			for (int i = 0; i < lines.length; i++) {  // 각각의 선분에 대해
				int start = lines[i][0];
				int end = lines[i][1];
				for (int j = start; j < end; j++) {  // 시작 위치부터 종료 위치까지 표현
					field[j + 100] += 1;
				}
			}

			// 2. 겹치는 선분의 길이 도출(0: 없음, 1: 하나의 선분, 2 이상: 겹쳐 있음)
			int count = 0;
			for (int i = 0; i < field.length; i++) {
				if (field[i] > 1) {
					count += 1;
				}
			}

			return count;
		}

	}


	// Libraries
	private int[] toArray(ArrayList<Integer> al) {
		// ArrayList<Integer> to int[]
		int[] arr = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			arr[i] = al.get(i);
		}
		return arr;
	}

}
