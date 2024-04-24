package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class _Solution_181868 {
	// 공백으로 구분하기 2
	// https://school.programmers.co.kr/learn/courses/30/lessons/181868
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "i  love you ";
		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String s) {
			return s.trim().split("\\s+");
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
