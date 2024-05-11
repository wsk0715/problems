package kr.co.programmers.school.solved.acceptance;

import java.util.Arrays;

public class _Solution_181858 {
	// 무작위로 K개의 수 뽑기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181858
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int k) {
			int[] n = new int[100_001];
			int[] r = new int[k];
			Arrays.fill(r, -1);
			for (int i = 0; i < arr.length; i++) {
				if (n[arr[i]] > 0) {
					continue;
				}
				for (int j = 0; j < r.length; j++) {
					if (r[j] == -1) {
						r[j] = arr[i];
						break;
					}
				}
				n[arr[i]] += 1;
			}
			return r;
		}

	}

}
