package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class Solution_120924 {
	// 다음에 올 숫자
	// https://school.programmers.co.kr/learn/courses/30/lessons/120924
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] input = {1, 2, 3, 4};
		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] c) {
			boolean cha = false;
			// 1. 0 포함 확인, 0 존재 -> 등차수열(등비가 0이 아니라는 조건)
			for (int i = 0; i < c.length; i++) {
				if (c[i] == 0) {
					cha = true;
					break;
				}
			}
			// 1-1. 등차수열 확인
			if (c[2] - c[1] == c[1] - c[0]) {
				cha = true;
			}
			int r = 0;

			// 2. 등차수열인 경우
			if (cha) {
				r = c[c.length - 1] + (c[1] - c[0]);  // 마지막 항에 공차를 더한 값
				return r;
			}

			// 3. 그 외의 경우, 등비수열
			r = c[c.length - 1] * (c[1] / c[0]);
			return r;
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

}
