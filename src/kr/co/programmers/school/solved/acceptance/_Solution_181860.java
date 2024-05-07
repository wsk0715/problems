package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181860 {
	// 빈 배열에 추가, 삭제하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181860
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, boolean[] flag) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < flag.length; i++) {
				if (flag[i]) {
					for (int j = 0; j < arr[i] * 2; j++) {
						al.add(arr[i]);
					}
					continue;
				}
				for (int j = 0; j < arr[i]; j++) {
					al.remove(al.size() - 1);
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
