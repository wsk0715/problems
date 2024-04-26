package kr.co.programmers.school.solved.beginner;

public class Solution_120906 {
	// 자릿수 더하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120906
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int sum = 0;

			String s = String.valueOf(n);
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - 48;
			}

			return sum;
		}

	}

}
