package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181865 {
	// 간단한 식 계산하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/181865
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String s) {
			String[] arr = s.split(" ");
			int a = Integer.parseInt(arr[0]);
			String op = arr[1];
			int b = Integer.parseInt(arr[2]);
			return op.equals("+") ? a + b : op.equals("-") ? a - b : a * b;
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
