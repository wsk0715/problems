package kr.co.programmers.school.solved;

import java.util.Arrays;

public class Solution_120585 {
	// 머쓱이보다 키 큰 사람
	// https://school.programmers.co.kr/learn/courses/30/lessons/120585
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] array, int height) {
			Arrays.sort(array);

			int count = 0;
			for (int h : array) {
				if (h > height) {
					count++;
				}
			}
			return count;
		}

	}

}
