package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181886 {
	// 5명씩
	// https://school.programmers.co.kr/learn/courses/30/lessons/181886
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String[] solution(String[] arr) {
			ArrayList<String> al = new ArrayList<>();

			int i = 0;
			while (arr.length > i) {
				al.add(arr[i]);
				i += 5;
			}
			return toArray(al);
		}


		// Libraries
		private String[] toArray(ArrayList<String> al) {
			String[] arr = new String[al.size()];
			for (int i = 0; i < al.size(); i++) {
				arr[i] = al.get(i);
			}
			return arr;
		}

	}

}
