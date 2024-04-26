package kr.co.programmers.school.solved.beginner;

public class Solution_120837 {
	// 개미 군단
	// https://school.programmers.co.kr/learn/courses/30/lessons/120837
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int hp) {
			int[] dmgs = new int[]{5, 3, 1};

			int count = 0;
			for (int d : dmgs) {
				count += hp / d;
				hp = hp % d;
			}

			return count;
		}

	}

}
