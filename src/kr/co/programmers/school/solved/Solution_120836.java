package kr.co.programmers.school.solved;

public class Solution_120836 {
	// 순서쌍의 개수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120836
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
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
