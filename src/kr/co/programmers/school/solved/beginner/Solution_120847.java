package kr.co.programmers.school.solved.beginner;

import java.util.Arrays;

public class Solution_120847 {
	// 최댓값 만들기(1)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120847
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] numbers) {
			Arrays.sort(numbers);

			return numbers[numbers.length - 1] * numbers[numbers.length - 2];
		}

	}

}
