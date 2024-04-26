package kr.co.programmers.school.solved.beginner;

public class Solution_120910 {
	// 세균 증식
	// https://school.programmers.co.kr/learn/courses/30/lessons/120910
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n, int t) {
			return n * (int) Math.pow(2, t);
		}

	}

}
