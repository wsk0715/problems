package kr.co.programmers.school.solved;

public class Solution_120887 {
	// k의 개수
	// https://school.programmers.co.kr/learn/courses/30/lessons/120887
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int from, int to, int k) {
			int count = 0;
			for (int i = from; i <= to; i++) {
				String s = String.valueOf(i);
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == (k + 48)) {
						count++;
					}
				}
			}
			return count;
		}

	}

}
