package kr.co.programmers.school.solved.lv1;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Solution_12944 {
	// 평균 구하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12944
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public double solution(int[] arr) {
			OptionalDouble avg = Arrays.stream(arr)
									   .average();
			return avg.getAsDouble();
		}

	}

}
