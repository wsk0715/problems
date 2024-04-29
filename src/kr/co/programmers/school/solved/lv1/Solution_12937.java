package kr.co.programmers.school.solved.lv1;

public class Solution_12937 {
	// 짝수와 홀수 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12937
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(int n) {
			if (n % 2 == 0) {
				return "Even";
			}
			return "Odd";
		}

	}

}
