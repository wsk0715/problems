package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;

public class _Solution_68935 {
	// 3진법 뒤집기 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/68935
	public static void main(String[] args) {
		Solution sol = new Solution();

		int input = 45;
		sol.solution(input);
	}

	static class Solution {
		public int solution(int n) {
			return toDecimal(new StringBuffer(toTrinary(n).toString()).reverse()
																	  .toString());
		}

		public int toDecimal(String trinary) {
			int r = 0;
			int l = trinary.length();

			for (int i = 0; i < l; i++) {
				int n = trinary.charAt(i) - 48;
				r += n * (int) Math.pow(3, l - 1 - i);
			}

			System.out.println(r);
			return r;
		}

		public String toTrinary(int n) {
			if (n == 0) {
				return "0";
			}

			StringBuilder sb = new StringBuilder();
			while (n > 0) {
				sb.insert(0, (n % 3));
				n /= 3;
			}
			return sb.toString();
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
