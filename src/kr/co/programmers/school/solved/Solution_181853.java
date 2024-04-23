package kr.co.programmers.school.solved;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_181853 {
	// 뒤에서 5등까지
	// https://school.programmers.co.kr/learn/courses/30/lessons/181853
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr) {
			Arrays.sort(arr);

			int[] r = new int[5];
			for (int i = 0; i < 5; i++) {
				r[i] = arr[i];
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
