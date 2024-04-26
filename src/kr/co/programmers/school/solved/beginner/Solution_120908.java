package kr.co.programmers.school.solved.beginner;

public class Solution_120908 {
	// 문자열안에 문자열
	// https://school.programmers.co.kr/learn/courses/30/lessons/120908
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String str1, String str2) {
			if (str1.contains(str2)) {
				return 1;
			}
			return 2;
		}

	}

}
