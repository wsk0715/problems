package kr.co.programmers.school.solved;

import java.util.ArrayList;

public class Solution_120897 {
	// 약수 구하기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120897
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int n) {
			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					arr.add(i);
				}
			}
			int[] result = new int[arr.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = arr.get(i);
			}
			return result;
		}

	}

}
