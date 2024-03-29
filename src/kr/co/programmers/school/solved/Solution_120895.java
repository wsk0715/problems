package kr.co.programmers.school.solved;

public class Solution_120895 {
	// 인덱스 바꾸기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120895
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s, int num1, int num2) {
			StringBuilder sb = new StringBuilder(s);
			String a = s.substring(num1, num1 + 1);
			String b = s.substring(num2, num2 + 1);
			return sb.replace(num1, num1 + 1, b).replace(num2, num2 + 1, a).toString();
		}

	}

}
