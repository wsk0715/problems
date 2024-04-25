package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181896 {
	// 첫 번째로 나오는 음수
	// https://school.programmers.co.kr/learn/courses/30/lessons/181896
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0) {
					return i;
				}
			}
			return -1;
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
