package kr.co.programmers.school.solved.beginner;

import java.util.Arrays;

public class Solution_120811 {
	// 중앙값 구하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120811
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] array) {
			int answer = 0;

			Arrays.sort(array);
			int median = array.length / 2;
			answer = array[median];

			return answer;
		}

	}

}
