package kr.co.programmers.school.solved;

import java.util.Arrays;

public class Solution_120889 {
	// 삼각형의 완성조건(1)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120889
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] sides) {
			Arrays.sort(sides);
			if (sides[0] + sides[1] > sides[2]) {
				return 1;
			}
			return 2;
		}

	}

}
