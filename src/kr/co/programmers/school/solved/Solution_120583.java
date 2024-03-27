package kr.co.programmers.school.solved;

public class Solution_120583 {
	// 중복된 문자 갯수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120583
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] array, int n) {
			int count = 0;

			for (int m : array) {
				if (n == m) {
					count++;
				}
			}
			return count;
		}

	}

}
