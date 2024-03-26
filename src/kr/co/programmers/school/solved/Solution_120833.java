package kr.co.programmers.school.solved;

public class Solution_120833 {
	// 배열 자르기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120833
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] numbers, int num1, int num2) {
			int[] arr = new int[num2 - num1 + 1];

			for (int i = num1; i <= num2; i++) {
				arr[i - num1] = numbers[i];
			}

			return arr;
		}

	}

}
