package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181856 {
	// 배열 비교하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181856
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr1, int[] arr2) {
			// 1. 배열의 길이 비교
			int l1 = arr1.length;
			int l2 = arr2.length;
			if (l1 > l2) {
				return 1;
			}
			if (l2 > l1) {
				return -1;
			}

			// 2. 같은 경우, 배열 원소 합 비교
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < l1; i++) {
				sum1 += arr1[i];
				sum2 += arr2[i];
			}

			if (sum1 > sum2) {
				return 1;
			}
			if (sum2 > sum1) {
				return -1;
			}
			return 0;
		}


		// Libraries
		private int[] toArray(ArrayList<Integer> al) {
			// ArrayList<Integer> to int[]
			int[] arr = new int[al.size()];
			for (int i = 0; i < al.size(); i++) {
				arr[i] = al.get(i);
			}
			return arr;
		}

	}

}
