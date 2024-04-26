package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181850 {
	// 정수 부분
	// https://school.programmers.co.kr/learn/courses/30/lessons/181850
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(double n) {
			return (int) n;
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
