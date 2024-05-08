package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Arrays;

public class _Solution_181862 {
	// 세 개의 구분자
	// https://school.programmers.co.kr/learn/courses/30/lessons/181862
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String s) {
			String[] r = Arrays.stream(s.replaceAll("[abc]", " ")
										.replaceAll("\\s+", " ")
										.trim()
										.split(" "))
							   .filter(str -> !str.isEmpty())
							   .toArray(String[]::new);
			return r.length > 0 ? r : new String[]{"EMPTY"};
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
