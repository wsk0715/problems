package kr.co.programmers.school.solved;

import java.util.Arrays;

public class Solution_120890 {
	// 가까운 수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120890
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] array, int n) {
			Arrays.sort(array);
			int[] arr = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				int sub = array[i] - n;
				arr[i] = (sub >= 0) ? sub : -sub;
			}

			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
					idx = i;
				}
			}
			return array[idx];
		}

	}

}
