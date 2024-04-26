package kr.co.programmers.school.solved.beginner;

import java.util.Arrays;

public class Solution_120869 {
	// 외계어 사전
	// https://school.programmers.co.kr/learn/courses/30/lessons/120869
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println((sol.solution(new String[]{"z", "d", "x"}, new String[]{"def", "dww", "dzx", "loveaw"})));
	}

	static class Solution {
		public int solution(String[] spell, String[] dic) {
			String[][] dicCopy = new String[dic.length][];
			for (int i = 0; i < dicCopy.length; i++) {
				dicCopy[i] = new String[dic[i].length()];

				for (int j = 0; j < dic[i].length(); j++) {
					dicCopy[i][j] = String.valueOf(dic[i].charAt(j));
				}
				Arrays.sort(dicCopy[i]);
			}
			Arrays.sort(spell);

			int result = 2;
			for (int i = 0; i < dicCopy.length; i++) {
				if (Arrays.toString(dicCopy[i])
						  .equals(Arrays.toString(spell))) {
					result = 1;
					break;
				}
			}
			return result;
		}

	}

}
