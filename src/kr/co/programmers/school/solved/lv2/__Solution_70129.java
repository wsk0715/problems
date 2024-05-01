package kr.co.programmers.school.solved.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class __Solution_70129 {
	// 이진 변환 반복하기 - lv.2
	// https://school.programmers.co.kr/learn/courses/30/lessons/70129
	public static void main(String[] args) {
		Solution sol = new Solution();

		String input = "110010101001";
		sol.solution(input);
	}

	static class Solution {
		public int[] solution(String s) {
			int t = 0;
			int n = 0;

			while (!s.equals("1")) {
				t += 1;
				int b = s.length();
				s = s.replaceAll("0", "");
				int a = s.length();
				n += b - a;

				s = toBinary(a);
			}

			int[] r = new int[]{t, n};
			System.out.println(Arrays.toString(r));
			return r;
		}

		private String toBinary(int length) {
			if (length == 0) {
				return "0";
			}
			StringBuilder sb = new StringBuilder();
			while (length > 0) {
				sb.insert(0, length % 2);
				length /= 2;
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
