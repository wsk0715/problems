package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181918 {
	// 배열 만들기 4
	// https://school.programmers.co.kr/learn/courses/30/lessons/181918
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr) {
			ArrayList<Integer> stk = new ArrayList<>();
			int i = 0;
			while (i < arr.length) {
				if (stk.isEmpty()) {
					stk.add(arr[i++]);
					continue;
				}
				int l = stk.size() - 1;
				int last = stk.get(l);
				if (last < arr[i]) {
					stk.add(arr[i++]);
				} else if (last >= arr[i]) {
					stk.remove(l);
				}
			}
			return toArray(stk);
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
