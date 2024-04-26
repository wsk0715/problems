package kr.co.programmers.school.solved.beginner;

public class Solution_120818 {
	// 옷가게 할인 받기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120818
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int price) {
			if (price >= 500_000) {
				price *= 0.8;  // 20%
			} else if (price >= 300_000) {
				price *= 0.9;  // 10%
			} else if (price >= 100_000) {
				price *= 0.95;  // 5%
			}
			return price;
		}

	}

}
