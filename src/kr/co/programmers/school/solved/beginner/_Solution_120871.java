package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120871 {
	// 저주의 숫자 3
	// https://school.programmers.co.kr/learn/courses/30/lessons/120871
	public static void main(String[] args) {
		Solution sol = new Solution();

		int input = 40;
		sol.solution(input);
	}


	static class Solution {
		public int solution(int n) {
			int t = 0;  // n에 도달할 때까지 반복할 수
			int m = 0;  // 3x 마을 숫자

			while (t < n) {
				t += 1;
				m += 1;
				while (true) {
					if (calcBreakCondition(m)) {
						break;
					}
					m += 1;
				}
			}
			return m;
		}

		public boolean calcBreakCondition(int m) {
			// 조건:
			boolean cond1 = m % 3 == 0;  // 1. 3의 배수인 수
			boolean cond2 = ((m % 100) / 10) - 3 == 0;  // 2. 십의 자리에 3
			boolean cond3 = ((m % 10) % 100) - 3 == 0;  // 3. 일의 자리에 3

			return !(cond1 || cond2 || cond3);
		}


		// Libraries
		private int[] toArray(ArrayList<Integer> al) {
			// ArrayList<Integer> to int[]
			int[] arr = new int[al.size()];
			for (int i = 0; i < al.size(); i++) {
				arr[i] = al.get(i);
			}
			return arr;
		}

	}

}
