package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181895 {
	// 배열 만들기 3
	// https://school.programmers.co.kr/learn/courses/30/lessons/181895
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int[][] intervals) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < intervals.length; i++) {
				for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
					al.add(arr[j]);
				}
			}
			return toArray(al);
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
