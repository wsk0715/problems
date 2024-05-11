package kr.co.programmers.school.solved.acceptance;

public class _Solution_181923 {
	// 수열과 구간 쿼리 2
	// https://school.programmers.co.kr/learn/courses/30/lessons/181923
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int[][] queries) {
			int[] r = new int[queries.length];
			for (int i = 0; i < queries.length; i++) {
				int s = queries[i][0];
				int e = queries[i][1];
				int k = queries[i][2];
				int min = Integer.MAX_VALUE;
				for (int j = s; j <= e; j++) {
					if (k < arr[j]) {
						min = Math.min(arr[j], min);
					}
				}
				r[i] = min == Integer.MAX_VALUE ? -1 : min;
			}
			return r;
		}

	}

}
