package kr.co.programmers.school.solved.beginner;

public class Solution_120886 {
	// A로 B 만들기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120886
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println((sol.solution("olleh", "hello")));
	}

	static class Solution {
		public int solution(String before, String after) {
			int[] arrBefore = new int[26];
			int[] arrAfter = new int[26];
			for (int i = 0; i < before.length(); i++) {
				arrBefore[before.charAt(i) - 97]++;
				arrAfter[after.charAt(i) - 97]++;
			}

			for (int i = 0; i < arrBefore.length; i++) {
				if (arrBefore[i] == arrAfter[i]) {

				} else {
					return 0;
				}
			}
			return 1;
		}

	}

}
