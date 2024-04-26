package kr.co.programmers.school.solved.beginner;

public class Solution_120846 {
	// 합성수 찾기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120846
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (getDivs(i) >= 3) {
					count++;
				}
			}
			return count;
		}

		public int getDivs(int n) {
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					count++;
				}
			}
			return count;
		}

	}

}
