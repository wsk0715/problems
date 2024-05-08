package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181912 {
	// 배열 만들기 5
	// https://school.programmers.co.kr/learn/courses/30/lessons/181912
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(String[] intStrs, int k, int s, int l) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < intStrs.length; i++) {
				int n = Integer.parseInt(intStrs[i].substring(s, s + l));
				if (n > k) {
					al.add(n);
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
