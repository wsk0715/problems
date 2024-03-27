package kr.co.programmers.school.solved;

public class Solution_120909 {
	// 제곱수 판별하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120909
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int m = (int) Math.sqrt(n);

			if (Math.pow(m, 2) == n) {
				return 1;
			}
			return 2;
		}

	}

}
