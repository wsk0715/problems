package kr.co.programmers.school.solved;

public class Solution_120840 {
	// 구슬을 나누는 경우의 수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120840
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n, int m) {
			double[] factorial = new double[31];
			factorial[0] = 1;

			for (int i = 1; i < factorial.length; i++) {
				factorial[i] = factorial[i - 1] * i;
			}

			return (int) Math.round(factorial[n] / factorial[m] / factorial[n - m]);
		}

	}

}
