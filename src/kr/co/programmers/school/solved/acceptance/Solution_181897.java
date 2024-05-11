package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181897 {
	// 리스트 자르기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181897
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int n, int[] slicer, int[] num_list) {
			int a = slicer[0];
			int b = slicer[1];
			int c = slicer[2];

			ArrayList<Integer> al = new ArrayList<>();
			switch (n) {
				case 1:
					for (int i = 0; i <= b; i++) {
						al.add(num_list[i]);
					}
					break;
				case 2:
					for (int i = a; i < num_list.length; i++) {
						al.add(num_list[i]);
					}
					break;
				case 3:
					for (int i = a; i <= b; i++) {
						al.add(num_list[i]);
					}
					break;
				case 4:
					for (int i = a; i <= b; i += c) {
						al.add(num_list[i]);
					}
					break;
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
