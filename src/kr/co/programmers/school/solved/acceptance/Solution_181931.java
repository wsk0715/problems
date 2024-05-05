package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181931 {
	// 등차수열의 특정한 항만 더하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181931
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int a, int d, boolean[] included) {
			int sum = 0;
			for (int i = 0; i < included.length; i++) {
				if (included[i]) {
					sum += a + d * i;
				}
			}
			return sum;
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
