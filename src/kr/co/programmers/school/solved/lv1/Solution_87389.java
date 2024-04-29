package kr.co.programmers.school.solved.lv1;

public class Solution_87389 {
	// 나머지가 1이 되는 수 찾기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/87389
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int m = n - 1;
			for (int i = 2; i <= m; i++) {
				if (m % i == 0) {
					return i;
				}
			}
			return 0;
		}

	}

}
