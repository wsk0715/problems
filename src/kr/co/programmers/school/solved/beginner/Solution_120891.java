package kr.co.programmers.school.solved.beginner;

public class Solution_120891 {
	// 369게임
	// https://school.programmers.co.kr/learn/courses/30/lessons/120891
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			String s = String.valueOf(n);
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if ((ch != '0') && (ch - 48) % 3 == 0) {
					count++;
				}
			}
			return count;
		}

	}

}
