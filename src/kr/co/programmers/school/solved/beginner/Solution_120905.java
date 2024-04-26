package kr.co.programmers.school.solved.beginner;

import java.util.ArrayList;

public class Solution_120905 {
	// n의 배수 고르기
	// https://school.programmers.co.kr/learn/courses/30/lessons/120905
	public static void main(String[] args) {
		Solution sol = new Solution();

//		int[] input = {};
//		sol.solution(input);
	}

	static class Solution {
		public int[] solution(int n, int[] numlist) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < numlist.length; i++) {
				if (numlist[i] % n == 0) {
					arr.add(numlist[i]);
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
