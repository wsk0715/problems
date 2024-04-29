package kr.co.programmers.school.solved.lv1;

public class Solution_12912 {
	// 두 정수 사이의 합 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12912
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public long solution(int a, int b) {
			int small = Math.min(a, b);
			int big = Math.max(a, b);
			long sum = 0;
			for (int i = small; i <= big; i++) {
				sum += i;
			}
			return sum;
		}

	}

}
