package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class _Solution_181837 {
	// 커피 심부름
	// https://school.programmers.co.kr/learn/courses/30/lessons/181837
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(String[] order) {
			int sum = 0;
			for (int i = 0; i < order.length; i++) {
				// 카페라떼
				if (order[i].contains("cafelatte")) {
					sum += 5000;
					continue;
				}
				// 아메리카노
				sum += 4500;
			}
			return sum;
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
