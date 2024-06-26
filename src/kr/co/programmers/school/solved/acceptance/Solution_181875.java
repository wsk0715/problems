package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181875 {
	// 배열에서 문자열 대소문자 변환하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181875
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String[] arr) {
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 != 0) {
					arr[i] = arr[i].toUpperCase();
					continue;
				}
				arr[i] = arr[i].toLowerCase();
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
