package kr.co.programmers.school.solved;

public class Solution_12934 {
	// 정수 제곱근 판별 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12934
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public long solution(long n) {
			long m = (long) Math.sqrt(n);
			if (m * m == n) {
				return (m + 1) * (m + 1);
			}
			return -1;
		}

	}

}
