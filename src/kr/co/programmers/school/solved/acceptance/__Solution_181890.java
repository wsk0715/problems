package kr.co.programmers.school.solved.acceptance;

import java.util.Arrays;

public class __Solution_181890 {
	// 왼쪽 오른쪽
	// https://school.programmers.co.kr/learn/courses/30/lessons/181890
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String[] str_list) {
			int s = -1;
			int e = -1;
			for (int i = 0; i < str_list.length; i++) {
				if (str_list[i].equals("l")) {
					s = 0;
					e = i - 1;
					break;
				}
				if (str_list[i].equals("r")) {
					s = i + 1;
					e = str_list.length - 1;
					break;
				}
			}
			if (s == -1) {
				return new String[]{};
			}
			return Arrays.copyOfRange(str_list, s, e + 1);
		}

	}

}
