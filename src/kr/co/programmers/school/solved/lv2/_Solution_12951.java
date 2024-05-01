package kr.co.programmers.school.solved.lv2;

import java.util.ArrayList;

public class _Solution_12951 {
	// JadenCase 문자열 만들기 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/12951
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "  3people     unFollowed me";
		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			String[] arr = s.toLowerCase()
							.split(" ", -1);
			for (int i = 0; i < arr.length; i++) {
				String st = arr[i];
				// 공백문자 예외
				if (st.isEmpty()) {
					continue;
				}

				// 숫자인 경우
				char ch = st.charAt(0);
				if (48 <= ch && ch <= 57) {
					continue;
				}

				String first = st.substring(0, 1);
				arr[i] = st.replaceFirst(first, first.toUpperCase());
			}

			String r = String.join(" ", arr);
			System.out.println(r);
			return r;
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
