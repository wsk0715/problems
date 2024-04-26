package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_181852 {
	// 뒤에서 5등 위로
	// https://school.programmers.co.kr/learn/courses/30/lessons/181852
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr) {
			Arrays.sort(arr);

			int[] r = new int[arr.length - 5];
			for (int i = 0; i < arr.length - 5; i++) {
				r[i] = arr[i + 5];
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
