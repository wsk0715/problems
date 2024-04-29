package kr.co.programmers.school.solved.lv1;

public class Solution_12903 {
	// 가운데 글자 가져오기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12903
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			if (s.length() % 2 == 0) {
				return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
			} else {
				return s.substring(s.length() / 2, s.length() / 2 + 1);
			}
		}

	}

}
