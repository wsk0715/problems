package kr.co.programmers.school.solved;

public class Solution_120831 {
	// 짝수의 합
	// https://school.programmers.co.kr/learn/courses/30/lessons/120831
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int sum = 0;

			for (int i = 0; i <= n; i++) {
				if (i % 2 == 0) {
					sum += i;
				}
			}

			return sum;
		}

	}

}
