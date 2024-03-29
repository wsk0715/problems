package kr.co.programmers.school.solved;

public class Solution_77884 {
	// 약수의 개수와 덧셈 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/77884
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int l, int r) {
			int result = 0;
			for (int i = l; i <= r; i++) {
				int count = 0;
				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						count++;
					}
				}
				if (count % 2 == 0) {
					result += i;
				} else {
					result -= i;
				}
			}
			return result;
		}

	}

}
