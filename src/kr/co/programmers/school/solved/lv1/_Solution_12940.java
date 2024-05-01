package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;

public class _Solution_12940 {
	// 최대공약수와 최소공배수 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12940
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int n, int m) {
			int gcd = getGCD(n, m);
			return new int[]{gcd, n * m / gcd};
		}

		public int getGCD(int a, int b) {
			if (b == 0) {
				return a;
			}
			return getGCD(b, a % b);
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
