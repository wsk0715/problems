package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181936 {
	// 공배수
	// https://school.programmers.co.kr/learn/courses/30/lessons/181936
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int solution(int number, int n, int m) {
			int lcm = n * m / getGcd(n, m);
			if (number % lcm == 0) {
				return 1;
			}
			return 0;
		}

		public int getGcd(int a, int b) {
			if (b == 0) {
				return a;
			}
			return getGcd(b, a % b);
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
