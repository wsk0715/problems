package kr.co.programmers.school.solved;

public class Solution_12931 {
	// 자릿수 더하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12931
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			String s = String.valueOf(n);
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - 48;
			}
			return sum;
		}

	}

}
