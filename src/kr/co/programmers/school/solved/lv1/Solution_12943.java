package kr.co.programmers.school.solved.lv1;

public class Solution_12943 {
	// 콜라츠 추측 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12943
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(long n) {
			for (int i = 0; i < 500; i++) {
				if (n == 1) {
					return i;
				}
				if (n % 2 == 0) {
					n /= 2;
				} else {
					n *= 3;
					n += 1;
				}
			}
			return -1;
		}

	}

}
