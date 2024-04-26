package kr.co.programmers.school.solved.beginner;

public class Solution_120884 {
	// 치킨 쿠폰
	// https://school.programmers.co.kr/learn/courses/30/lessons/120884
	public static void main(String[] args) {
		Solution sol = new Solution();

		int input = 1081;
		sol.solution(input);
	}

	static class Solution {
		public int solution(int chicken) {
			int coupon = chicken;
			int result = 0;
			while (true) {
				int bonus = coupon / 10;
				if (bonus < 1) {
					break;
				}
				result += bonus;
				coupon -= bonus * 9;
			}
			return result;
		}

	}

}
