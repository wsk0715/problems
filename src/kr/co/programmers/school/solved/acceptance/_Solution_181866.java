package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Arrays;

public class _Solution_181866 {
	// 문자열 잘라서 정렬하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181866
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String s) {
			String[] r = s.split("x");
			return Arrays.stream(r)
						 .filter(st -> !st.isEmpty())
						 .sorted()
						 .toArray(String[]::new);
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
