package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class _Solution_120885 {
	// 이진수 더하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120885
	public static void main(String[] args) {
		Solution sol = new Solution();

		sol.solution("10", "11");
		sol.solution("1001", "1111");
		sol.solution("0", "0");
	}

	static class Solution {
		public String solution(String bin1, String bin2) {
			int r = toDecimal(bin1) + toDecimal(bin2);
			return toBinary(r);
		}

		public int toDecimal(String binary) {
			int n = 0;
			int l = binary.length();
			for (int i = 0; i < l; i++) {
				int v = binary.charAt(i) - 48;
				n += v * Math.pow(2, l - 1 - i);
			}
			return n;
		}

		public String toBinary(int decimal) {
			if (decimal == 0) {
				return "0";
			}
			StringBuilder sb = new StringBuilder();
			while (decimal > 0) {
				int v = decimal % 2;
				decimal /= 2;
				sb = sb.insert(0, v);
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
