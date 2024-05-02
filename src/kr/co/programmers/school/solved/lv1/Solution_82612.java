package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;

public class Solution_82612 {
	// 부족한 금액 계산하기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/82612
	public static void main(String[] args) {
		Solution sol = new Solution();

		sol.solution(3, 20, 4);
	}

	static class Solution {
		public long solution(int p, int m, int n) {
			long sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += p * i;
			}
			long r = sum > m ? sum - m : 0;
			System.out.println(r);
			return r;
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
