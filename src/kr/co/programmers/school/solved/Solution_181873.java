package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_181873 {
	// 특정한 문자를 대문자로 바꾸기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181873
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(String s, String a) {
			return s.replaceAll(a, a.toUpperCase());
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
