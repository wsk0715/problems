package kr.co.programmers.school.solved.lv1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_12910 {
	// 나누어 떨어지는 숫자 배열 - lv.1
	// https://school.programmers.co.kr/learn/courses/30/lessons/12910
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int[] arr, int d) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int n : arr) {
				if (n % d == 0) {
					list.add(n);
				}
			}
			Collections.sort(list);
			int[] result;
			if (list.size() == 0) {
				return new int[]{-1};
			} else {
				result = new int[list.size()];
				for (int i = 0; i < result.length; i++) {
					result[i] = list.get(i);
				}
				return result;
			}

		}

	}

}
