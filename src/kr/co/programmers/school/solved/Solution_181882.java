package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181882 {
	// 조건에 맞게 수열 변환하기 1
	// https://school.programmers.co.kr/learn/courses/30/lessons/181882
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	/**
	 *
	 */
	static class Solution {
		public int[] solution(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 == 0) {  // 짝수인 경우
					if (arr[i] >= 50) {  // 50 이상인 경우
						arr[i] /= 2;
					}
					continue;
				}
				// 홀수인 경우
				if (arr[i] <= 50) {  // 50 이하인 경우
					arr[i] *= 2;
				}
			}
			return arr;
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
