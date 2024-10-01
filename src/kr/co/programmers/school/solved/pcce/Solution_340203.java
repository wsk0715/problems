package kr.co.programmers.school.solved.pcce;

public class Solution_340203 {

	// 심폐소생술
	// https://school.programmers.co.kr/learn/courses/30/lessons/340203
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		//		int[] n = {};
		//		System.out.println(sol.solution(n));
	}

	static class Solution {

		public int[] solution(String[] cpr) {
			int[] answer = {0, 0, 0, 0, 0};
			String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

			for (int i = 0; i < cpr.length; i++) {
				for (int j = 0; j < basic_order.length; j++) {
					if (cpr[i].equals(basic_order[j])) {
						answer[i] = j + 1;
						break;
					}
				}
			}
			return answer;
		}

	}

}
