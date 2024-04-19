package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class _Solution_120868 {
	// 삼각형의 완성조건 (2)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120868
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] input = {11, 7};
		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] s) {
			// 11, 7 예시
			// 5 6 7 8 9 10 11 12 13 14 15 16 17
			// (bigger - smaller + 1)  ~  (bigger + smaller - 1)
			// a부터 b 사이의 수는 b - a + 1
			return 2 * Math.min(s[0], s[1]) - 1;
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
