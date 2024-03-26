package kr.co.programmers.school.solved;

public class Solution_120841 {
	// 점의 위치 구하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120841
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] dot) {
			if (dot[0] * dot[1] < 0) {
				if (dot[0] < 0) {
					return 2;
				} else {
					return 4;
				}
			} else {
				if (dot[0] < 0) {
					return 3;
				} else {
					return 1;
				}
			}
		}

	}

}
