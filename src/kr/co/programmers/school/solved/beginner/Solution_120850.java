package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_120850 {
	// 문자열 정렬하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120850
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "p2o4i8gj2";
		sol.solution(input);
	}

	static class Solution {
		public int[] solution(String my_string) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < my_string.length(); i++) {
				char ch = my_string.charAt(i);
				if (48 <= ch && ch <= 57) {
					arr.add(ch - 48);
				}
			}

			int[] result = new int[arr.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = arr.get(i);
			}
			Arrays.sort(result);

			return result;
		}

	}

}
