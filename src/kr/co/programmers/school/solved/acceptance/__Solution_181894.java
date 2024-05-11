package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Arrays;

public class __Solution_181894 {
	// 2의 영역
	// https://school.programmers.co.kr/learn/courses/30/lessons/181894
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr) {
			int start = -1;
			int end = -1;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 2) {
					// start는 맨 처음 등장하는 2의 인덱스
					if (start == -1) {
						start = i;
					}
					// end는 2가 등장할 때마다 갱신, 결과적으로 마지막 2의 인덱스 표현
					end = i;
				}
			}

			if (start == -1) {
				return new int[]{-1};
			}

			return Arrays.copyOfRange(arr, start, end + 1);
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
