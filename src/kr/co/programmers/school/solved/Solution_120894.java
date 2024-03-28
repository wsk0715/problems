package kr.co.programmers.school.solved;

public class Solution_120894 {
	// 영어가 싫어요
	// https://school.programmers.co.kr/learn/courses/30/lessons/120894
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public long solution(String s) {
			String[] e = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};
			String[] f = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
			for (int i = 0; i < e.length; i++) {
				s = s.replaceAll(e[i], f[i]);
			}
			return Long.parseLong(s);
		}

	}

}
