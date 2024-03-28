package kr.co.programmers.school.solved;

public class Solution_120843 {
	// 공 던지기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120843
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(new int[]{1, 2, 3}, 1));
	}

	static class Solution {
		public int solution(int[] numbers, int k) {
			int result = 1;
			for (int i = 1; i < k; i++) {
				if (result + 1 == numbers[numbers.length - 1]) {
					result = 1;
					continue;
				} else if (result == numbers[numbers.length - 1]) {
					result = 2;
					continue;
				}
				result += 2;
			}
			return result;
		}

	}

}
