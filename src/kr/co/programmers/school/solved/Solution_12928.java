package kr.co.programmers.school.solved;

public class Solution_12928 {
	// 약수의 합 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12928
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					sum += i;
				}
			}
			return sum;
		}

	}

}
