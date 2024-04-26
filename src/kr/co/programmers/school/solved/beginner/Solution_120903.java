package kr.co.programmers.school.solved.beginner;

public class Solution_120903 {
	// 배열의 유사도
	// https://school.programmers.co.kr/learn/courses/30/lessons/120903
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String[] s1, String[] s2) {
			int count = 0;

			for (int i = 0; i < s1.length; i++) {
				for (int j = 0; j < s2.length; j++) {
					if (s1[i].equals(s2[j])) {
						count++;
					}
				}
			}
			return count;
		}

	}

}
