package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181885 {
	// 할 일 목록
	// https://school.programmers.co.kr/learn/courses/30/lessons/181885
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String[] arr, boolean[] fin) {
			ArrayList<String> al = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (!fin[i]) {
					al.add(arr[i]);
				}
			}
			return toArray(al);
		}


		// Libraries
		private String[] toArray(ArrayList<String> al) {
			// ArrayList<Integer> to int[]
			String[] arr = new String[al.size()];
			for (int i = 0; i < al.size(); i++) {
				arr[i] = al.get(i);
			}
			return arr;
		}

	}

}
