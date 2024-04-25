package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181888 {
	// n개 간격의 원소들
	// https://school.programmers.co.kr/learn/courses/30/lessons/181888
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int n) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < arr.length; i += n) {
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
