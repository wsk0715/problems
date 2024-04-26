package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class Solution_120805 {
	// 몫 구하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120805
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int num1, int num2) {
			return num1 / num2;
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
