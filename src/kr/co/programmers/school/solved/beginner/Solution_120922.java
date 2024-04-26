package kr.co.programmers.school.solved.beginner;

public class Solution_120922 {
	// 종이 자르기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120922
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int M, int N) {
			int big = (M < N) ? N : M;
			int small = (M < N) ? M : N;

			return big - 1 + (small - 1) * big;
		}

	}

}
