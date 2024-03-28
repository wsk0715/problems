package kr.co.programmers.school.solved;

public class Solution_120848 {
	// 팩토리얼
	// https://school.programmers.co.kr/learn/courses/30/lessons/120848
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int i = 1;
			while (factorial(i) <= n) {
				i += 1;
			}
			return i - 1;
		}

		public int factorial(int n) {
			if (n <= 1) {
				return 1;
			}
			return n * factorial(n - 1);
		}

	}

}
