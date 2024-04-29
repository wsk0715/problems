package kr.co.programmers.school.solved.lv1;

public class Solution_12919 {
	// 서울에서 김서방 찾기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12919
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String[] s) {
			for (int i = 0; i < s.length; i++) {
				if (s[i].equals("Kim")) {
					return String.format("김서방은 %d에 있다", i);
				}
			}
			return "";
		}

	}

}
