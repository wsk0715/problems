package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120923 {
	// 연속된 수의 합
	// https://school.programmers.co.kr/learn/courses/30/lessons/120923
	public static void main(String[] args) {
		Solution sol = new Solution();

		int num = 5;
		int total = 5;
		sol.solution(num, total);
	}

	static class Solution {
		public int[] solution(int n, int t) {
			int[] r = new int[n];
			for (int i = -n; i <= t; i++) {
				// 1. 연속된 n개의 수를 더해 t가 나오지 않는다면
				if ((n * i) + ((n - 1) * n / 2) != t) {  // i + (i+1) + .. != t
					continue;  // 무시
				}
				for (int j = 0; j < n; j++) {  // 2. t가 나온다면
					r[j] = i + j;  // 연속된 n개의 수를 결과로 저장
				}
				break;  // 3. 반복 종료
			}

			return r;
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
