package kr.co.programmers.school.solved.lv1;

public class Solution_131705 {

	// 삼총사 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/131705
	public static void main(String[] args) {
		Solution sol = new Solution();

		// #case 1
		int[] number = {-2, 3, 0, 2, -5};
		System.out.println(sol.solution(number));

		// #case 2
		int[] number2 = {-3, -2, -1, 0, 1, 2, 3};
		System.out.println(sol.solution(number2));

		// #case 3
		int[] number3 = {-1, 1, -1, 1};
		System.out.println(sol.solution(number3));
	}

	static class Solution {

		public int solution(int[] number) {
			int answer = 0;
			for (int i = 0; i < number.length; i++) {
				for (int j = i + 1; j < number.length; j++) {
					for (int k = j + 1; k < number.length; k++) {
						if (number[i] + number[j] + number[k] == 0) {
							answer += 1;
						}
					}
				}
			}

			return answer;
		}

	}

}
