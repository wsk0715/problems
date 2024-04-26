package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class Solution_120809 {
	// 배열 두배 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120809
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] *= 2;
			}
			return arr;
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
