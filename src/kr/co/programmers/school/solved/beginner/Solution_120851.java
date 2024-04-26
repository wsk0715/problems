package kr.co.programmers.school.solved.beginner;

public class Solution_120851 {
	// 숨어있는 숫자의 덧셈(1)
	// https://school.programmers.co.kr/learn/courses/30/lessons/120851
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String my_string) {
			int sum = 0;
			for (int i = 0; i < my_string.length(); i++) {
				if (48 <= my_string.charAt(i) && my_string.charAt(i) <= 57) {
					sum += my_string.charAt(i) - 48;
				}
			}
			return sum;
		}

	}

}
