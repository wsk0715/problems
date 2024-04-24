package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181874 {
	// A 강조하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181874
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			return s.toLowerCase().replaceAll("a", "A");
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
