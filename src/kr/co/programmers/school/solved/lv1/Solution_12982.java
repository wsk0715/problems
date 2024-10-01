package kr.co.programmers.school.solved.lv1;

import java.util.Arrays;

public class Solution_12982 {

	// 예산 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12982
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] d = {1, 3, 2, 5, 4};
		int budget = 9;
		System.out.println(sol.solution(d, budget));

		// #case 2
		int[] d2 = {2, 2, 3, 3};
		int budget2 = 10;
		System.out.println((sol.solution(d2, budget2)));
	}

	static class Solution {

		public int solution(int[] d, int budget) {
			int answer = 0;

			Arrays.sort(d);
			for (int i : d) {
				budget -= i;
				answer += 1;

				if (budget < 0) {
					answer -= 1;
					break;
				}
			}

			return answer;
		}

	}

}
