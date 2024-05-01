package kr.co.programmers.school.solved.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_12939 {
	// 최댓값과 최솟값 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/12939
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s) {
			int[] arr = Arrays.stream(s.split(" "))
							  .mapToInt(Integer::parseInt)
							  .toArray();
			Arrays.sort(arr);
			return new String(arr[0] + " " + arr[arr.length - 1]);
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
