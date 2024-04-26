package kr.co.programmers.school.solved.beginner;

public class Solution_120904 {
	// 숫자 찾기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120904
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int num, int k) {
			String s = String.valueOf(num);
			for (int i = 0; i < s.length(); i++) {
				if (k == (int) s.charAt(i) - 48) {
					return i + 1;
				}
			}
			return -1;
		}

	}

}
