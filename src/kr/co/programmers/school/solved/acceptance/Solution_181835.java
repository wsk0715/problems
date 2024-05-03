package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_181835 {
	// 조건에 맞게 수열 변환하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181835
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int k) {
			if (k % 2 == 0) {
				return Arrays.stream(arr)
							 .map(x -> x + k)
							 .toArray();
			}
			return Arrays.stream(arr)
						 .map(x -> x * k)
						 .toArray();
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
