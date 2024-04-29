package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_12935 {
	// 제일 작은 수 제거하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12935
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] input = {2, 3, 1, 4};
		System.out.println(Arrays.toString(sol.solution(input)));
	}

	static class Solution {
		public int[] solution(int[] arr) {
			if (arr.length == 1) {
				return new int[]{-1};
			}
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
					minIdx = i;
				}
			}
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (i == minIdx) {
					continue;
				}
				al.add(arr[i]);
			}
			int[] result = new int[al.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = al.get(i);
			}
			return result;
		}

	}

}
