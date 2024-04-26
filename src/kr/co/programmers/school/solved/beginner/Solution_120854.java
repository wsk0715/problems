package kr.co.programmers.school.solved.beginner;

public class Solution_120854 {
	// 배열 원소의 길이
	// https://school.programmers.co.kr/learn/courses/30/lessons/120854
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(String[] strlist) {
			int[] answer = new int[strlist.length];

			for (int i = 0; i < strlist.length; i++) {
				answer[i] = strlist[i].length();
			}

			return answer;
		}

	}

}
