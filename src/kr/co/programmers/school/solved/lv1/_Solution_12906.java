package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;

public class _Solution_12906 {
	// 같은 숫자는 싫어 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12906
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr) {
			ArrayList<Integer> al = new ArrayList<>();

			Integer before = null;
			for (int i = 0; i < arr.length; i++) {
				Integer n = arr[i];
				if (n.equals(before)) {
					continue;
				}
				before = n;
				al.add(n);
			}
			return toArray(al);
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
