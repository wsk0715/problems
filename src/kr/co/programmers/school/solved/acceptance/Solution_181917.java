package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181917 {
	// 간단한 논리 연산
	// https://school.programmers.co.kr/learn/courses/30/lessons/181917
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
			return (x1 || x2) && (x3 || x4);
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
