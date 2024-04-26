package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class Solution_120804 {
	// 두 수의 곱
	// https://school.programmers.co.kr/learn/courses/30/lessons/120804
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int num1, int num2) {
			return num1 * num2;
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
