package kr.co.programmers.school.solved.pcce;

public class Solution_250129 {

	// 산책
	// https://school.programmers.co.kr/learn/courses/30/lessons/250129
	public static void main(String[] args) {
		Solution sol = new Solution();

		//		int[] input = {};
		//		sol.solution(input);
	}

	static class Solution {

		public int[] solution(String route) {
			int east = 0;
			int north = 0;
			int[] answer = new int[2];
			for (int i = 0; i < route.length(); i++) {
				switch (route.charAt(i)) {
					case 'N':
						north++;
						break;
					case 'S':
						north--;
						break;
					case 'E':
						east++;
						break;
					case 'W':
						east--;
						break;
				}
			}
			answer[0] = east;
			answer[1] = north;
			return answer;
		}

	}

}
