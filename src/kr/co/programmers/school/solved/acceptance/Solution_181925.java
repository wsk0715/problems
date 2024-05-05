package kr.co.programmers.school.solved.acceptance;

import java.util.ArrayList;

public class Solution_181925 {
	// 수 조작하기 2
	// https://school.programmers.co.kr/learn/courses/30/lessons/181925
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public String solution(int[] numLog) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < numLog.length - 1; i++) {
				switch (numLog[i + 1] - numLog[i]) {
					case 1:
						sb.append("w");
						break;
					case -1:
						sb.append("s");
						break;
					case 10:
						sb.append("d");
						break;
					case -10:
						sb.append("a");
						break;
				}
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
