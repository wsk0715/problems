package kr.co.programmers.school.solved.beginner;

import java.util.Arrays;

public class Solution_120864 {
	// 숨어있는 숫자의 덧셈(2)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120864
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "";
		sol.solution(input);
	}

	static class Solution {
		public int solution(String s) {
			StringBuilder sb = new StringBuilder(s);
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (48 <= ch && ch <= 57) {

				} else {
					sb.replace(i, i + 1, " ");
				}
			}
			if (sb.length() == 0) {
				return 0;
			} else {
				int[] arr = Arrays
						.stream(sb.toString()
								  .split(" "))
						.filter(x -> !x.isEmpty())
						.mapToInt(Integer::parseInt)
						.toArray();
				int sum = Arrays.stream(arr)
								.sum();
				return sum;
			}
		}

	}

}
