package kr.co.programmers.school.solved.lv1;

public class Solution_70128 {
	// 내적 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/70128
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] a, int[] b) {
			int sum = 0;
			for (int i = 0; i < a.length; i++) {
				sum += a[i] * b[i];
			}
			return sum;
		}

	}

}
