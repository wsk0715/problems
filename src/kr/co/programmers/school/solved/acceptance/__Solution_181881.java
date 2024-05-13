package kr.co.programmers.school.solved.acceptance;

public class __Solution_181881 {
	// 조건에 맞게 수열 변환하기 2
	// https://school.programmers.co.kr/learn/courses/30/lessons/181881
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] input = {1, 2, 3, 100, 99, 98};
		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr) {
			int r = 0;

			while (!checkCondition(arr)) {
				// 조건 만족하지 않을 시, 연산 수행
				calc(arr);
				r += 1;
			}

			return r;
		}

		public void calc(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				//  짝수인 경우
				if (arr[i] % 2 == 0) {
					// 50 이상일 경우
					if (arr[i] >= 50) {
						arr[i] /= 2;
					}
					continue;
				}
				// 홀수이면서, 50 미만인 경우
				if (arr[i] < 50) {
					arr[i] *= 2;
					arr[i] += 1;
				}
			}
		}

		public boolean checkCondition(int[] arr) {
			// 종료조건: 연산 전과 연산 후 배열 상태가 같아야 함 -> 각각의 원소가 다음 조건을 만족하도록 해야 함.
			// 1. 짝수인 경우, 50 미만이어야 한다.
			// 2. 홀수인 경우, 50 이상이어야 한다.
			for (int i = 0; i < arr.length; i++) {
				//  짝수인 경우
				if (arr[i] % 2 == 0) {
					// 50 이상일 경우
					if (arr[i] >= 50) {
						return false;
					}
					continue;
				}
				// 홀수이면서, 50 미만인 경우
				if (arr[i] < 50) {
					return false;
				}
			}
			return true;
		}

	}

}
