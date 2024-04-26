package kr.co.programmers.school.solved.beginner;

public class Solution_120844 {
	// 배열 회전시키기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120844
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] numbers, String direction) {
			int[] result = new int[numbers.length];
			if (direction.equals("right")) {
				result[0] = numbers[numbers.length - 1];

				for (int i = 1; i < numbers.length; i++) {
					result[i] = numbers[i - 1];
				}
			} else {
				result[numbers.length - 1] = numbers[0];

				for (int i = 0; i < numbers.length - 1; i++) {
					result[i] = numbers[i + 1];
				}
			}
			return result;
		}

	}

}
