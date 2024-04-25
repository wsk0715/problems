package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181892 {
	// n번째 원소부터
	// https://school.programmers.co.kr/learn/courses/30/lessons/181892
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int n) {
			ArrayList<Integer> al = new ArrayList<>();

			for (int i = n - 1; i < arr.length; i++) {
				al.add(arr[i]);
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
