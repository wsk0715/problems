package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181854 {
	// 배열의 길이에 따라 다른 연산하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181854
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int n) {
			int l = arr.length;

			// 홀수 길이인 경우
			if (l % 2 != 0) {
				for (int i = 0; i < l; i += 2) {
					arr[i] += n;
				}
				return arr;
			}

			// 짝수 길이인 경우
			for (int i = 1; i < l; i += 2) {
				arr[i] += n;
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
