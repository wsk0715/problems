package kr.co.programmers.school.solved;

public class Solution_120892 {
	// 암호 해독
	// https://school.programmers.co.kr/learn/courses/30/lessons/120892
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String cipher, int code) {
			StringBuilder sb = new StringBuilder();
			for (int i = code - 1; i < cipher.length(); i += code) {
				sb.append(cipher.charAt(i));
			}

			return sb.toString();
		}

	}

}
