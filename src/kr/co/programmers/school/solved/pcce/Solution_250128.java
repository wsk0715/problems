package kr.co.programmers.school.solved.pcce;

public class Solution_250128 {

	// 가채점
	// https://school.programmers.co.kr/learn/courses/30/lessons/250128
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		//		int[] n = {};
		//		System.out.println(sol.solution(n));
	}

	static class Solution {

		public String[] solution(int[] numbers, int[] our_score, int[] score_list) {
			int num_student = numbers.length;
			String[] answer = new String[num_student];

			for (int i = 0; i < num_student; i++) {
				if (our_score[i] == score_list[numbers[i] - 1]) {
					answer[i] = "Same";
				} else {
					answer[i] = "Different";
				}
			}

			return answer;
		}

	}

}
