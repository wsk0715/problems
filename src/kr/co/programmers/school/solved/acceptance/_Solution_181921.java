package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181921 {
	// 배열 만들기 2
	// https://school.programmers.co.kr/learn/courses/30/lessons/181921
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int l, int r) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = l; i <= r; i++) {
				String s = String.valueOf(i);
				if (s.matches("^[05]*$")) {
					al.add(i);
				}
			}
			if (al.isEmpty()) {
				return new int[]{-1};
			}
			return al.stream()
					 .mapToInt(i -> i)
					 .toArray();
		}

	}

}
